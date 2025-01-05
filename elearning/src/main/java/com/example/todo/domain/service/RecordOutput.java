package com.example.todo.domain.service;

import java.util.List;

public class RecordOutput implements Output {

    List<RecordInf> unitTest;

    public List<RecordInf> getUnitTest() {
        return unitTest;
    }

    public void setUnitTest(List<RecordInf> unitTest) {
        this.unitTest = unitTest;
    }

    @Override
    public String toString() {
        return "RecordOutput [unitTest=" + unitTest + "]";
    }
    
    

}
