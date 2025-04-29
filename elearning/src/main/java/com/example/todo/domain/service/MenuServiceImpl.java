package com.example.todo.domain.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.example.todo.domain.model.Content;
import com.example.todo.domain.model.Lab;
import com.example.todo.domain.model.TeamInf;
import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.model.UserInf;
import com.example.todo.domain.repository.LabRepository;
import com.example.todo.domain.repository.QuesRepository;
import com.example.todo.domain.repository.TeamInfRepository;
import com.example.todo.domain.repository.UnitTestRepository;
import com.example.todo.domain.repository.UserInfRepository;

@Service
public class MenuServiceImpl {

    @Inject
    UnitTestRepository unitTest;
    
    
    @Inject
    UserInfRepository userInf;
    
    @Inject
    LabRepository lab;
    
    @Inject
    QuesRepository ques;

    @Inject
    TeamInfRepository teamInf;

    public List<UnitTest> findAll() {
        return unitTest.findAll();
    }

    public UnitTestOutput findSource(String quesNum, String sourceId) {

        UnitTest v = unitTest.findSource(sourceId);
        

        UnitTestOutput result = new UnitTestOutput();
        String a = IOUtils.toString(v.getSource(), "UTF-8");
        result.setSource(a);
        result.setSourceId(sourceId);
        result.setScore(v.getScore());
        result.setDuration((long) v.getDuration());
        result.setSize((long) v.getSize());
        result.setQuesNum(quesNum);
        result.setUserName(userInf.findUser(v.getUserId()).getUserName());
        String name = ques.findDetail(quesNum).getQuesName();
        result.setQuesName(name);

        result.setStatus(getStrStatus(v.getStatus()));

        return result;
    }

    public List<RanksOutput> findRankbyScope(long scope) {

        List<RanksOutput> result = new ArrayList<RanksOutput>();;

        List<Content> a = ques.findContents(scope);
        a.forEach(aa->{
            List<RankOutput> ut = unitTest.findRanksByNum(aa.getQuesNum());
            int i = 0;
            for(RankOutput u: ut) {
                if(u.getScore() == null) {
                    u.setScore(0L);
                    u.setRank("-");
                }else {
                    i=i+1;
                    u.setRank(String.valueOf(i));
                }
            }

            RanksOutput menu = new RanksOutput();
            Content c = ques.findDetail(aa.getQuesNum());
            menu.setQuesName(c.getQuesName());
            menu.setCnt(ut.size());
            menu.setRankInf(ut);
            result.add(menu);
        });

        return result;
    }

    public List<RankOutput> findRank(List<Lab> result) {
        
        List<RankOutput> rList = new ArrayList<RankOutput>();
        
        return rList;
    }

    public List<Lab> findTittle(String userId) {
        UserInf u = userInf.findUser(userId);
        TeamInf t = teamInf.findTeamName(u.getTeamId());
        List<Lab> a = lab.findAll(t.getAccess());
        return a;
    }

    private String getStrStatus(long status) {
        
        if(status==0) {
            return "評価中";
        }else if(status==1){
            return "全クリア";
        }else if(status==2) {
            return "一部クリア";
        }else {
            return "異常";
        }
    }


}
