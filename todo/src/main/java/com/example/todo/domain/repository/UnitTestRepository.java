package com.example.todo.domain.repository;

import java.util.Collection;

import com.example.todo.domain.model.UnitTest;

public interface UnitTestRepository {

    Collection<UnitTest> findAll();
    
    UnitTest findBySnum(String sNum);

    void create(UnitTest enitity);

    void updateBySnum(UnitTest entity);
    
    boolean isSourceNum(String sNum);

}
