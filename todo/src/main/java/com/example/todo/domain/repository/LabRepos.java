package com.example.todo.domain.repository;

import java.util.Collection;
import java.util.List;

import com.example.todo.domain.model.Lab;

public interface LabRepos {

    Collection<Lab> findAll();

    List<Lab> findLab();

    String findName(long scopeNum);
}
