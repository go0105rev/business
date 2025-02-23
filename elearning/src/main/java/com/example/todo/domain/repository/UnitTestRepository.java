package com.example.todo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.todo.domain.model.UnitTest;

public interface UnitTestRepository {

    List<UnitTest> findAll();
    
    List<UnitTest> findBySnum(@Param("userId")String userId, @Param("quesNum")String quesNum);

    void create(UnitTest enitity);

    void updateBySnum(long version, @Param("userId")String userId, @Param("quesNum")String quesNum);
    
    long countBySourceNum(@Param("sNum")String sNum);

    Long nextNum(@Param("year")String year);

    UnitTest findSource(@Param("sourceId")String sourceId);

}
