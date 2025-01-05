package com.example.todo.domain.model;

import java.io.InputStream;
import java.util.Date;

public class UnitTest {

    private String sourceId;

    private String userId;

    private String quesNum;

    private long version;

    private InputStream source;

    private Date saveTime;

    // TODO 消したい。
    private String strSaveTime;

    private long size;

    private long duration;

    private long score;

    
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

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getStrSaveTime() {
        return strSaveTime;
    }

    public void setStrSaveTime(String strSaveTime) {
        this.strSaveTime = strSaveTime;
    }

    @Override
    public String toString() {
        return "UnitTest [userId=" + userId + ", quesNum=" + quesNum
                + ", version=" + version + ", saveTime=" + saveTime
                + ", strSaveTime=" + strSaveTime + ", size=" + size
                + ", duration=" + duration + ", score=" + score + "]";
    }

    
}
