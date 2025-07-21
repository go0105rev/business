package elearningBatch.service.evaculation;

import java.util.List;

public class TestResult extends TestTemplate {

    String sourceId;

    List<String> output;

    String others;

    long exeMillSecond;
    
    long exeMem;

    int exeScore;

    public TestResult(String sourceId, List<String> output, int exeMillSecond,
            int exeScore, String others) {
        super();
        this.sourceId = sourceId;
        this.output = output;
        this.exeMillSecond = exeMillSecond;
        this.exeScore = exeScore;
    }

    public TestResult(String num, int score, List<String> input, List<String> expectvalue,
            int expectMillSecond) {
        super(num, score, input, expectvalue, expectMillSecond);
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    public long getExeMillSecond() {
        return exeMillSecond;
    }

    public void setExeMillSecond(long exeMillSecond) {
        this.exeMillSecond = exeMillSecond;
    }

    
    public long getExeMem() {
        return exeMem;
    }

    public void setExeMem(long exeMem) {
        this.exeMem = exeMem;
    }

    public int getExeScore() {
        return exeScore;
    }

    public void setExeScore(int exeScore) {
        this.exeScore = exeScore;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "TestResult [sourceId=" + sourceId + ", exeValue=" + output
                + ", others=" + others + ", exeMillSecond=" + exeMillSecond
                + ", exeMem=" + exeMem + ", exeScore=" + exeScore
                + ", toString()=" + super.toString() + "]";
    }

}
