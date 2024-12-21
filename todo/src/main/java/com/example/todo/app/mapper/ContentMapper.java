package com.example.todo.app.mapper;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.example.todo.domain.service.Input;

public class ContentMapper implements Input{

    
    @NotNull
    @Size(min=1,max=1000)
    private String context;

    private LabMapper content;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
    
    public LabMapper getContent() {
        return content;
    }

    public void setContent(LabMapper content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ContentMapper [context=" + context + ", content=" + content
                + "]";
    }


    
    
}
