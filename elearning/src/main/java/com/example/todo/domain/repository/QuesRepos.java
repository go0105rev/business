package com.example.todo.domain.repository;

import java.util.Collection;
import java.util.List;

import com.example.todo.domain.model.Content;

public interface QuesRepos {

    Collection<Content> findAll();

    List<Content> findContent(long ques);

    Content findDetail(String quesNum);
    
    String findName(String quesNum);

}
