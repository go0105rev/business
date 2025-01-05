package com.example.todo.domain.service;

public class UnitTestOutput implements Output{

    private long resCd;
    
    private String date;

    public long getResCd() {
        return resCd;
    }

    public void setResCd(long resCd) {
        this.resCd = resCd;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
