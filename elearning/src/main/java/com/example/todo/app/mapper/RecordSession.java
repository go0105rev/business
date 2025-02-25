package com.example.todo.app.mapper;

import java.util.List;

import com.example.todo.domain.model.Lab;

public class RecordSession {

    private String teamId;
    
    private List<Lab> labInf;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    
    public List<Lab> getLabInf() {
        return labInf;
    }

    public void setLabInf(List<Lab> labInf) {
        this.labInf = labInf;
    }

    public void setLab(List<Lab> labInf) {
        this.labInf=labInf;
        
    }
    
    
}
