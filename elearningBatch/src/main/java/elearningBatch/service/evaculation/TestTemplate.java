package elearningBatch.service.evaculation;

import java.util.List;

public class TestTemplate {

    String num;

    List<String> input;

    List<String> expectvalue;

    int expectMillSecond;

    int score;

    
    public TestTemplate() {
        super();
    }

    public TestTemplate(String num, int score, List<String> input, List<String> expectvalue,
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

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    public List<String> getExpectvalue() {
        return expectvalue;
    }

    public void setExpectvalue(List<String> expectvalue) {
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
