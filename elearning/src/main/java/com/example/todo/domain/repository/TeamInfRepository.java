package com.example.todo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.todo.domain.model.TeamInf;

public interface TeamInfRepository {

    List<TeamInf> findAll();

    TeamInf findTeamName(@Param("teamId") String teamId);
}
