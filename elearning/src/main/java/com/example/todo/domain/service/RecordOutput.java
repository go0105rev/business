package com.example.todo.domain.service;

import java.util.List;

public class RecordOutput implements Output {

    private String quesNum;
    private String quesName;
    private int cnt;
    List<UnitTestOutput> unitTest;
    public String getQuesNum() {
        return quesNum;
    }
    public void setQuesNum(String quesNum) {
        this.quesNum = quesNum;
    }
    public String getQuesName() {
        return quesName;
    }
    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }
    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    public List<UnitTestOutput> getUnitTest() {
        return unitTest;
    }
    public void setUnitTest(List<UnitTestOutput> unitTest) {
        this.unitTest = unitTest;
    }

    @Override
    public String toString() {
        return "RecordOutput [quesNum=" + quesNum + ", quesName=" + quesName
                + ", cnt=" + cnt + ", unitTest=" + unitTest + "]";
    }

}
