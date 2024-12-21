package com.example.todo.app.mapper;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LabMapper {

    private long scope;

    private long ques;

    private String quesNum;

    @NotNull
    @Size(min = 1, max = 1000)
    private String context;

    public long getScope() {
        return scope;
    }

    public void setScope(long scope) {
        this.scope = scope;
    }

    public long getQues() {
        return ques;
    }

    public void setQues(long ques) {
        this.ques = ques;
    }

    public String getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(String quesNum) {
        this.quesNum = quesNum;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

}
