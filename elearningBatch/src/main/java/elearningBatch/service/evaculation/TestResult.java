package elearningBatch.service.evaculation;

public class TestResult extends TestTemplate {

    String sourceId;

    String exeValue;

    String others;

    long exeMillSecond;
    
    long exeMem;

    int exeScore;

    public TestResult(String sourceId, String exeValue, int exeMillSecond,
            int exeScore, String others) {
        super();
        this.sourceId = sourceId;
        this.exeValue = exeValue;
        this.exeMillSecond = exeMillSecond;
        this.exeScore = exeScore;
    }

    public TestResult(String num, int score, String input, String expectvalue,
            int expectMillSecond) {
        super(num, score, input, expectvalue, expectMillSecond);
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getExeValue() {
        return exeValue;
    }

    public void setExeValue(String exeValue) {
        this.exeValue = exeValue;
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
        return "TestResult [sourceId=" + sourceId + ", exeValue=" + exeValue
                + ", others=" + others + ", exeMillSecond=" + exeMillSecond
                + ", exeMem=" + exeMem + ", exeScore=" + exeScore
                + ", toString()=" + super.toString() + "]";
    }

}
