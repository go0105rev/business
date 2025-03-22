package elearningBatch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import io.micrometer.common.util.StringUtils;

public abstract class Tasklets implements Tasklet {

    Logger logger = LoggerFactory.getLogger(Tasklets.class);

    @Override
    public RepeatStatus execute(StepContribution contribution,
            ChunkContext chunkContext) throws Exception {

        List<String> params = new ArrayList<>();

        int a = chunkContext.getStepContext().getJobParameters().size();
        Map<String, Object> c = chunkContext.getStepContext().getJobParameters();
        for (int i = 0; i < a; i++) {
            String s = (String) chunkContext.getStepContext().getJobParameters()
                    .get("arg" + i);
            if (StringUtils.isNotBlank(s)) {
                params.add(s);
            }
        }

        try {
            logger.info("バッチ処理開始します。");
            Status result = process(params);
            logger.info(result.name());

        } catch (Throwable e) {
            // TODO AOPでまとめたい。
            logger.error("[UNEXCEPT ERROR] --> ", e);
        }finally{
            logger.info("バッチ処理終了します。");
        }

        return RepeatStatus.FINISHED;
    }

    public abstract Status process(List<String> input);

    public enum Status {

        /** 正常終了。 */
        OK,

        /** 異常終了。 */
        NG;
    }
}
