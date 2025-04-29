package com.example.todo.app.mapper;

public class MenuMapper {
    
    private String sourceId;

    private String quesNum;
    
    private long scope;

    public String getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(String quesNum) {
        this.quesNum = quesNum;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public long getScope() {
        return scope;
    }

    public void setScope(long scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "MenuMapper [sourceId=" + sourceId + ", quesNum=" + quesNum
                + ", scope=" + scope + "]";
    }
    
    
}