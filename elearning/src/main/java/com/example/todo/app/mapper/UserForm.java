package com.example.todo.app.mapper;

public class UserForm {

    private String teamId;

    // TODO シーケンスで、動的に生成したい
    private String userId;

    private String pass;

    private String userName;

    private Integer gender;

    private long age;

    private long exp;

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    @Override
    public String toString() {
        return "UserForm [teamId=" + teamId + ", userId=" + userId
                + ", userName=" + userName + ", gender=" + gender + ", age="
                + age + ", exp=" + exp + "]";
    }

}
