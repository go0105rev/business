package com.example.todo.domain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder implements ApplicationContextAware{

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext arg) throws BeansException {
        
        context= arg;
        
    }


    public static <T> T getBean(String name, Class<T> type) {
        return context.getBean(name,type);
    }
}
