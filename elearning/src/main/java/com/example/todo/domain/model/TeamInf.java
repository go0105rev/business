package com.example.todo.domain.model;

import java.util.Date;

public class TeamInf {

    private String teamId;

    private String teamName;

    private Date sDate;

    private Date eDate;
    
    private String access;

    
    public TeamInf(String teamId, String teamName, Date sDate, Date eDate) {
        super();
        this.teamId = teamId;
        this.teamName = teamName;
        this.sDate = sDate;
        this.eDate = eDate;
    }

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

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    
}
