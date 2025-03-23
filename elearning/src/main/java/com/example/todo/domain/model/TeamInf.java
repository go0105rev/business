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

    /**
     * アクセス可能なスコープ群。
     * 
     * @return null:全オープン、0:公開可能のみオープン
     */
    public String getAccess() {
        return access;
    }

    /**
     * アクセス可能なスコープ群。
     * 
     * @param access null:全オープン、0:公開可能のみオープン
     */
    public void setAccess(String access) {
        this.access = access;
    }

    
}
