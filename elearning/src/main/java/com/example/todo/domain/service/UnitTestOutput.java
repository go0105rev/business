package com.example.todo.domain.service;

public class UnitTestOutput implements Output {

    private String source;

    private String sourceId;

    private String quesNum;

    private String quesName;

    private String userName;

    private String status;

    private Long size;

    private Long duration;

    private Long score;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(String quesNum) {
        this.quesNum = quesNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    
    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    @Override
    public String toString() {
        return "UnitTestOutput [source=" + source + ", sourceId=" + sourceId
                + ", quesNum=" + quesNum + ", quesName=" + quesName
                + ", userName=" + userName + ", status=" + status + ", size="
                + size + ", duration=" + duration + ", score=" + score + "]";
    }

    
}
