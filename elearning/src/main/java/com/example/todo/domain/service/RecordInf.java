package com.example.todo.domain.service;

import com.example.todo.domain.model.UnitTest;

public class RecordInf extends UnitTest {

    private String teamId;

    private String teamName;

    private String userName;

    private String quesName;

    private String scopeName;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    @Override
    public String toString() {
        return "RecordInf [teamId=" + teamId + ", teamName=" + teamName
                + ", userName=" + userName + ", quesName=" + quesName
                + ", scopeName=" + scopeName + ", toString()="
                + super.toString() + "]";
    }

}
