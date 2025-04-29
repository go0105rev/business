package com.example.todo.app.mapper;

public class RecordMapper {

    private long scope;
    private String sourceId;
    private String quesNum;

    public long getScope() {
        return scope;
    }

    public void setScope(long scope) {
        this.scope = scope;
    }


    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(String quesNum) {
        this.quesNum = quesNum;
    }

    @Override
    public String toString() {
        return "RecordMapper [scope=" + scope + ", sourceId=" + sourceId
                + ", quesNum=" + quesNum + "]";
    }
    
    
}
