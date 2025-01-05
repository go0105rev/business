package com.example.todo.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public abstract class BaseService<I,O> implements Blogic<I,O>{
    public O execute(I input) {
        O output = process(input);
        
        return output;
    }
    
    protected abstract O process(I input);
}
