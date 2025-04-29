package com.example.todo.domain.service;

import java.util.List;

public class MenuOutput {

    private String quesName;
    
    private int cnt;
    
    private List<UnitTestOutput> uniTest;

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public List<UnitTestOutput> getUniTest() {
        return uniTest;
    }

    public void setUniTest(List<UnitTestOutput> uniTest) {
        this.uniTest = uniTest;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    
    
    
}
