package com.example.todo.domain.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.example.todo.domain.model.TeamInf;
import com.example.todo.domain.model.UserInf;

@Repository
public class UserInfRepository implements UserInfRepos {

    private static final Map<String, UserInf> UserMaps = new ConcurrentHashMap<String, UserInf>();


    static {
        String pass="{pbkdf2@SpringSecurity_v5_8}08213e88e589717c40102a8d800c5dadf52435998ad2e2b924860062894dbb3a47a98d980dc1975862cd5b3925db1f3e";
        UserMaps.put("testUser001",
                new UserInf("G0001", "testUser001", "工藤一", pass,1, 23, 4, new Date(), null));
        UserMaps.put("testUser002",
                new UserInf("G0001", "testUser002", "工藤二", pass,2, 35, 10, new Date(), null));
        UserMaps.put("testUser003",
                new UserInf("G0002", "testUser003", "工藤三", pass,1, 20, 1, new Date(), null));
    }

    private static final Map<String, TeamInf> TeamMaps = new ConcurrentHashMap<String, TeamInf>();
    static {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            TeamMaps.put("G0001", new TeamInf("G0001", "爆上戦隊", sdf.parse(
                    "20250701"), null));
            TeamMaps.put("G0002", new TeamInf("G0002", "特捜戦隊", sdf.parse(
                    "20240701"), null));
            TeamMaps.put("G0003", new TeamInf("G0003", "秘密戦隊", sdf.parse(
                    "19750701"), null));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserInf> findAll() {
        return null;
    }

    @Override
    public UserInf findUser(String userId) {
        return UserMaps.get(userId);
    }

    @Override
    public TeamInf findTeamName(String teamId) {
        return TeamMaps.get(teamId);
    }

    @Override
    public void create(UserInf userInf) {
        UserMaps.put(userInf.getUserId(), userInf);

    }
}
