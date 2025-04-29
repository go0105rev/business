package com.example.todo.domain.service;

public class MenuRanksEntity {

    private String userId;
    
    private String userName;
    
    private int Score;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "MenuRanksEntity [userId=" + userId + ", userName=" + userName
                + ", Score=" + Score + "]";
    }
    
    
}
