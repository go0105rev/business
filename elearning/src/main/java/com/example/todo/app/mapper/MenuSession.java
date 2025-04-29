package com.example.todo.app.mapper;

import java.util.List;

import com.example.todo.domain.model.Lab;

public class MenuSession {

    private String userId;
    
    private List<Lab> lab;
    
    private long scope;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    public long getScope() {
        return scope;
    }

    public void setScope(long scope) {
        this.scope = scope;
    }

    public List<Lab> getLab() {
        return lab;
    }

    public void setLab(List<Lab> lab) {
        this.lab = lab;
    }
    
    

}
