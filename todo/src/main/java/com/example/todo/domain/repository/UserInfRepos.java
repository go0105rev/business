package com.example.todo.domain.repository;

import java.util.List;

import com.example.todo.domain.model.TeamInf;
import com.example.todo.domain.model.UserInf;

public interface UserInfRepos {

    List<UserInf> findAll();

    UserInf findUserName(String userId);

    TeamInf findTeamName(String teamId);
}
