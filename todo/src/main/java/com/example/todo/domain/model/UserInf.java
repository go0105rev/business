package com.example.todo.domain.model;

import java.util.Date;

public class UserInf {

    private String teamId;

    private String userId;
    
    private String password;

    private String userName;

    private Integer gender;

    private long age;

    private long exp;
    
    private Date sDate;

    private Date eDate;

    
    
    public UserInf() {
        super();
    }

    public UserInf(String teamId, String userId,String userName,
            Integer gender, long age, long exp, Date sDate, Date eDate) {
        super();
        this.teamId = teamId;
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.exp = exp;
        this.sDate = sDate;
        this.eDate = eDate;
    }

    public UserInf(String teamId, String userId,String userName,String password,
            Integer gender, long age, long exp, Date sDate, Date eDate) {
        super();
        this.teamId = teamId;
        this.userId = userId;
        this.userName = userName;
        this.password=password;
        this.gender = gender;
        this.age = age;
        this.exp = exp;
        this.sDate = sDate;
        this.eDate = eDate;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
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

    
}
