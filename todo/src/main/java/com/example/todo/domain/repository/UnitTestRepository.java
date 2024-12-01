package com.example.todo.domain.repository;

import java.util.Collection;

import com.example.todo.domain.model.UnitTest;

public interface UnitTestRepository {

    Collection<UnitTest> findAll();

    void create(UnitTest enitity);

}
