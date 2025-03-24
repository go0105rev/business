package com.example.todo.domain.model;

import java.util.Date;

public class UnitTest {

    private String sourceId;

    private String userId;

    private String quesNum;

    private short status;

    private Date savetime;

    // TODO 消したい
    private String strsavetime;

    private double size;

    private double duration;

    private long score;

    private byte[] source;

    private double memory;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(String quesNum) {
        this.quesNum = quesNum;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public byte[] getSource() {
        return source;
    }

    public void setSource(byte[] source) {
        this.source = source;
    }

    public Date getSaveTime() {
        return savetime;
    }

    public void setSaveTime(Date savetime) {
        this.savetime = savetime;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
    
    public Double getMemory() {
        return memory;
    }

    public void setMemory(Double memory) {
        this.memory = memory;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getStrSaveTime() {
        return strsavetime;
    }

    public void setStrSaveTime(String strsavetime) {
        this.strsavetime = strsavetime;
    }

    @Override
    public String toString() {
        return "UnitTest [sourceId=" + sourceId + ", userId=" + userId
                + ", quesNum=" + quesNum + ", status=" + status + ", savetime="
                + savetime + ", strsavetime=" + strsavetime + ", size=" + size
                + ", duration=" + duration + ", score=" + score + "]";
    }

}
