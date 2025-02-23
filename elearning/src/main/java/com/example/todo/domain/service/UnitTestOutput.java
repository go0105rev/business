package com.example.todo.domain.service;

public class UnitTestOutput implements Output{

    private String source;
    private String sourceId;
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



}
