package com.example.todo.app.welcome;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.example.todo.domain.service.Input;

public class UnitTestInput implements Input{

    private long scope;
    
    private int ques;
    
    @NotNull
    @Size(min=1,max=1000)
    private String context;

    public long getScope() {
        return scope;
    }


    public void setScope(long scope) {
        this.scope = scope;
    }

    public int getQues() {
        return ques;
    }

    public void setQues(int ques) {
        this.ques = ques;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }


    @Override
    public String toString() {
        return "UnitTestInput [scope=" + scope + ", ques=" + ques + "]";
    }
    
    
}
