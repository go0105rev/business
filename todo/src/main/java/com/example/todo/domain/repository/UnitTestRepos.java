package com.example.todo.domain.repository;

import java.util.Collection;
import java.util.List;

import com.example.todo.domain.model.UnitTest;

public interface UnitTestRepos {

    Collection<UnitTest> findAll();
    
    List<UnitTest> findBySnum(String userId, String quesNum);

    void create(UnitTest enitity);

    void updateBySnum(long version, String userId, String quesNum);
    
    boolean isSourceNum(String sNum);

}
