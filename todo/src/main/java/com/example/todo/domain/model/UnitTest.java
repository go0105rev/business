package com.example.todo.domain.model;

import java.io.InputStream;
import java.util.Date;

public class UnitTest {

    private String userId;

    private String quesNum;

    private long version;

    private InputStream source;

    private Date saveTime;

    private long size;

    private long duration;

    private long testFlg;

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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public InputStream getSource() {
        return source;
    }

    public void setSource(InputStream source) {
        this.source = source;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getTestFlg() {
        return testFlg;
    }

    public void setTestFlg(long testFlg) {
        this.testFlg = testFlg;
    }

}
