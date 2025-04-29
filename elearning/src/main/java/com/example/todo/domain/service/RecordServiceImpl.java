package com.example.todo.domain.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class RecordServiceImpl {

    @Inject
    UnitTestRepository unitTest;

    @Inject
    UserInfRepository userInf;

    @Inject
    QuesRepository ques;

    @Inject
    LabRepository lab;

    @Inject
    TeamInfRepository teamInf;

    public List<Lab> findTittle(String userId) {
        UserInf u = userInf.findUser(userId);
        TeamInf t = teamInf.findTeamName(u.getTeamId());
        List<Lab> a = lab.findAll(t.getAccess());
        return a;
    }

    public List<RecordOutput> findByScope(long scope) {

        List<RecordOutput> result = new ArrayList<RecordOutput>();;

        List<Content> a = ques.findContents(scope);
        a.forEach(aa->{
            List<UnitTestOutput> bList = new ArrayList<UnitTestOutput>();
            List<UnitTest> b = unitTest.findByNum(aa.getQuesNum());
            b.forEach(bb->{
                UnitTestOutput target = new UnitTestOutput();
                target.setQuesNum(bb.getQuesNum());
                String userName=userInf.findUser(bb.getUserId()).getUserName();
                target.setUserName(userName);
                target.setSourceId(bb.getSourceId());
                target.setScore(bb.getScore());
                target.setStatus(getStrStatus(bb.getStatus()));
                target.setSize((long)bb.getSize());
                target.setDuration((long)bb.getDuration());
                bList.add(target);
            });

            RecordOutput menu = new RecordOutput();
            Content c = ques.findDetail(aa.getQuesNum());
            menu.setQuesName(c.getQuesName());
            menu.setQuesNum(aa.getQuesNum());
            menu.setCnt(bList.size());
            menu.setUnitTest(bList);
            result.add(menu);
        });

        return result;
    }

    private boolean isAuth(TeamInf t, long scope) {

        if (t.getAccess()==null || t.getAccess().equals("0")) {
            return true;
        }
        for (String a : t.getAccess().split(",")) {
            if (a.equals(String.valueOf(scope))) {
                return true;
            }
        }
        return false;

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
