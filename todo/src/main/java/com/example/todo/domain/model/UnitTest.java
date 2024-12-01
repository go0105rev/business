package com.example.todo.domain.model;

import java.util.Date;

public class UnitTest {

    private long scope;
    
    private int ques;
    
    private String userId;
    
    private String sourceNum;
    
    private Date saveTime;

    public long getScope() {
        return scope;
    }

    public void setScope(long scope) {
        this.scope = scope;
    }

    public int getQues() {
        return ques;
    }

    public void setQues(int ques) {
        this.ques = ques;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSourceNum() {
        return sourceNum;
    }

    public void setSourceNum(String sourceNum) {
        this.sourceNum = sourceNum;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }
    
    
}
