package com.example.todo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.todo.domain.model.Content;

public interface QuesRepository {

    List<Content> findAll();

    List<Content> findContents(@Param("scope")long scope);

    Content findDetail(@Param("quesNum")String quesNum);

}
