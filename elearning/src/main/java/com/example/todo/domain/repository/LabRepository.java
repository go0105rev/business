package com.example.todo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.todo.domain.model.Lab;

public interface LabRepository {

    List<Lab> findAll(@Param("access")String access);

    String findName(long scope);
}
