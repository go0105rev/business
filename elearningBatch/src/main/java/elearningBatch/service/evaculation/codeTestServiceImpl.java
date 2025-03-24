package elearningBatch.service.evaculation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jakarta.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import elearningBatch.model.UnitTest;
import elearningBatch.repository.UnitTestRepository;
import elearningBatch.service.Tasklets;
import io.micrometer.core.instrument.util.IOUtils;

@Service
public class codeTestServiceImpl extends Tasklets {

    Logger logger = LoggerFactory.getLogger(codeTestServiceImpl.class);

    @Inject
    UnitTestRepository repository;

    @Override
    public Status process(List<String> input) {

        List<UnitTest> targets = repository.findAsVersion0();

        targets.forEach(t -> {

            String target = t.getSourceId();
            logger.debug(target + "[start]");

            String path = "/home/codeLearn/" + t.getUserId() + "/" + target
                    + "/";
            List<String> editClass = new ArrayList<>();
            editClass.add("javac");
            editClass.add(path + "Main.java");
            execute(new ProcessBuilder(editClass));

            try {
                List<String> cmd = new ArrayList<>();
                cmd.add("java");
                cmd.add("-cp");
                cmd.add(path);
                cmd.add("Main");

                File file = new File("/home/codeLearn/evaculation/" + t
                        .getQuesNum() + ".csv");
                List<TestResult> csv = convertToTest(file);
                // TODO inputからoutputを複製したい
                // Collections.copy(result,csv);

                for (TestResult i : csv) {
                    long total = Runtime.getRuntime().totalMemory();
                    long sMem = total-Runtime.getRuntime().freeMemory();
                    Process process = execute(new ProcessBuilder(cmd), i);
                    long eMem = total-Runtime.getRuntime().freeMemory();
                    i.setExeMem((eMem-sMem)/ 1024);
                    unitTest(target, i, process);
                    
                }
                evaculate(target, csv);

            } catch (Exception e) {
                UnitTest entity = new UnitTest();
                entity.setStatus((short) 9);
                repository.updateAsQues(entity, target);
                if (e instanceof IllegalArgumentException) {
                    logger.error("[targetFile Error]" + target, e);
                    return;
                } else {
                    logger.error("[System Error]" + target, e);
                    throw new IllegalStateException();
                }

            } finally {
                 File dir = new File(path);
                 for(File f : dir.listFiles()){
                 f.delete();
                 }
                 dir.delete();
            }

            logger.debug(target + "end");
        });

        return Status.OK;
    }

    /**
     * テストインプット生成。
     * @param file
     * @return テストインプット
     * @throws IOException
     */
    private List<TestResult> convertToTest(File file) throws IOException {

        // TODO openCsv差し替えるか
        try (BufferedReader br = new BufferedReader(new FileReader(file));) {

            List<TestResult> result = new ArrayList<>();
            String sbr;
            while ((sbr = br.readLine()) != null) {
                String[] s = sbr.split(",");
                TestResult e = new TestResult(s[0], Integer.parseInt(
                        s[1]), s[2], s[3], Integer.parseInt(s[4]));
                result.add(e);
            }
            return result;
        }
    }

    private TestResult unitTest(String target, TestResult input,
            Process process) throws IOException {

        long miliSec = process.info().totalCpuDuration().get().get(
                ChronoUnit.NANOS) / 1000000;
        
        int exit = process.exitValue();
        if (exit != 0) {
            try (BufferedReader errStream = process.errorReader(
                    StandardCharsets.UTF_8);) {
                StringBuilder sb = new StringBuilder();
                sb.append(target + " :");

                String es;
                while ((es = errStream.readLine()) != null) {
                    sb.append(es);
                }

                logger.error("statusCd[" + exit + "] sec [" + miliSec + "s]"
                        + sb.toString());
            }

            throw new IllegalArgumentException();

        } else {
            input.setExeMillSecond(miliSec);
            try (InputStream is = process.getInputStream();) {
                // TODO 最終行の改行文字のみ削りたい。
                input.setExeValue(IOUtils.toString(is, StandardCharsets.UTF_8)
                        .replaceAll("\\r\\n|\\r|\\n", ""));

                boolean ans;
                if (input.getExeValue().equals(input.getExpectvalue())) {
                    input.setExeScore(input.getScore());
                    ans = true;
                } else {
                    input.setExeScore(0);
                    ans = false;
                }
                logger.info(target + ": test001 [" + ans + "]");
            }
        }

        return input;

    }

    /**
     * テスト評価。
     * @param target
     * @param io
     */
    private void evaculate(String target, List<TestResult> io) {

        // TODO テスト結果をぷインとアウトしたい
        int standard = io.stream().mapToInt(t -> t.getScore()).sum();
        int total = io.stream().mapToInt(t -> t.getExeScore()).sum();
        double sumSec = io.stream().mapToLong(t -> t.getExeMillSecond())
                .average().getAsDouble();


        UnitTest e = new UnitTest();
        if (total == standard) {
            double aveTime = sumSec / io.size();
            if (aveTime > 0) {
                total += total;
            }
            e.setScore(Long.valueOf(total));
            double sumMem = io.stream().mapToLong(t -> t.getExeMem())
                    .average().getAsDouble();
            e.setMemory(sumMem / io.size());
            e.setDuration(aveTime);
            e.setStatus((short) 1);

        } else {
            e.setScore(Long.valueOf(total));
            e.setStatus((short) 2);
        }

        repository.updateAsQues(e, target);
    }

    /**
     * コマンド実行。（標準入力あり）
     * @param builder
     * @param input
     * @return
     */
    private Process execute(ProcessBuilder builder, TestTemplate input) {

        try {

            Process process = builder.start();
            try (OutputStream os = process.getOutputStream();) {
                byte[] b = input.getInput().getBytes();
                os.write(b);
                os.flush();
            }
            // TODO 時間設定しなくても良さそう
            process.waitFor(1000, TimeUnit.MILLISECONDS);

            return process;

        } catch (IOException | InterruptedException e) {
            throw new IllegalStateException();
        }
    }

    /**
     * コマンド実行。
     * @param builder
     * @param input
     * @return
     */
    private Process execute(ProcessBuilder builder) {

        try {

            Process process = builder.start();
            process.waitFor(1000, TimeUnit.MILLISECONDS);
            return process;

        } catch (IOException | InterruptedException e) {
            throw new IllegalStateException();
        }
    }
}
