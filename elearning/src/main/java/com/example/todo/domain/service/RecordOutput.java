package com.example.todo.domain.service;

import java.util.List;

public class RecordOutput implements Output {

    private String teamId;
    private String teamName;
    private Long teamScore;
    private Long wait;
    private Long clear;
    private Long warn;
    private Long error;
    private boolean own;
    List<UnitTestOutput> unitTest;

    
    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(Long teamScore) {
        this.teamScore = teamScore;
    }

    public Long getClear() {
        return clear;
    }

    public void setClear(Long clear) {
        this.clear = clear;
    }

    public Long getWait() {
        return wait;
    }

    public void setWait(Long wait) {
        this.wait = wait;
    }

    public Long getWarn() {
        return warn;
    }

    public void setWarn(Long warn) {
        this.warn = warn;
    }

    public Long getError() {
        return error;
    }

    public void setError(Long error) {
        this.error = error;
    }

    public boolean isOwn() {
        return own;
    }

    public void setOwn(boolean own) {
        this.own = own;
    }

    public List<UnitTestOutput> getUnitTest() {
        return unitTest;
    }

    public void setUnitTest(List<UnitTestOutput> unitTest) {
        this.unitTest = unitTest;
    }

    @Override
    public String toString() {
        return "RecordOutput [teamId=" + teamId + ", teamName=" + teamName
                + ", teamScore=" + teamScore + ", wait=" + wait + ", clear="
                + clear + ", warn=" + warn + ", error=" + error + ", own=" + own
                + ", unitTest=" + unitTest + "]";
    }

}
