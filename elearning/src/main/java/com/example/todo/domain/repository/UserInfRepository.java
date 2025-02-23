package com.example.todo.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.todo.domain.model.TeamInf;
import com.example.todo.domain.model.UserInf;

public interface UserInfRepository {

    List<UserInf> findAll();

    UserInf findUser(@Param("userId")String userId);

    TeamInf findTeamName(@Param("teamId")String teamId);

    void create(UserInf userInf);
}
