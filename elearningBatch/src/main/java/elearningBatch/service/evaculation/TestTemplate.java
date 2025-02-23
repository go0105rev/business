package elearningBatch.service.evaculation;

public class TestTemplate {

    String num;

    String input;

    String expectvalue;

    int expectMillSecond;

    int score;

    
    public TestTemplate() {
        super();
    }

    public TestTemplate(String num, int score, String input, String expectvalue,
            int expectMillSecond) {
        super();
        this.num = num;
        this.input = input;
        this.expectvalue = expectvalue;
        this.expectMillSecond = expectMillSecond;
        this.score = score;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getExpectvalue() {
        return expectvalue;
    }

    public void setExpectvalue(String expectvalue) {
        this.expectvalue = expectvalue;
    }

    public int getExpectMillSecond() {
        return expectMillSecond;
    }

    public void setExpectMillSecond(int expectMillSecond) {
        this.expectMillSecond = expectMillSecond;
    }

    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "TestInput [num=" + num + ", input=" + input + ", expectvalue="
                + expectvalue + ", expectMillSecond=" + expectMillSecond
                + ", score=" + score + "]";
    }

}
