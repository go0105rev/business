package com.example.todo.domain.repository;

import java.util.List;

import com.example.todo.domain.model.Lab;

public interface LabRepository {

    List<Lab> findAll();

    String findName(long scope);
}
