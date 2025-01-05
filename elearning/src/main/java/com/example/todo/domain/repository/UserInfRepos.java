package com.example.todo.domain.repository;

import java.util.List;

import com.example.todo.domain.model.TeamInf;
import com.example.todo.domain.model.UserInf;

public interface UserInfRepos {

    List<UserInf> findAll();

    UserInf findUser(String userId);

    TeamInf findTeamName(String teamId);

    void create(UserInf userInf);
}
