package com.example.todo.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.inject.Inject;

import org.apache.commons.lang3.StringUtils;
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

    public List<Lab> findTittle() {
        List<Lab> a = lab.findAll();
        return a;
    }

    public List<RecordOutput> findAllRecord(long scope, String teamId) {

        List<Content> quesIds = ques.findQues(scope);
        List<TeamInf> ts = teamInf.findAll();
        List<TeamInf> tss = ts.stream().filter(t -> isAuth(t, scope)).collect(
                Collectors.toList());

        List<RecordOutput> result = new ArrayList<RecordOutput>();
        tss.forEach(t -> {

            RecordOutput ou = new RecordOutput();
            ou.setUnitTest(new ArrayList<>());
            ou.setTeamName(teamInf.findTeamName(t.getTeamId()).getTeamName());
            ou.setTeamId(t.getTeamId());
            ou.setOwn(t.getTeamId().equals(teamId) ? true : false);

            List<UnitTest> a = unitTest.findBestByTeam(quesIds, t.getTeamId(),scope);
            a.forEach(e -> {
                UnitTestOutput target = new UnitTestOutput();
                target.setQuesNum(e.getQuesNum());
                target.setScore(e.getScore());
                target.setStatus(getStrStatus(e.getStatus()));
                target.setSize((long)e.getSize());
                target.setDuration((long)e.getDuration());
                Content c = ques.findDetail(e.getQuesNum());
                target.setQuesName(c.getQuesName());

                if(StringUtils.isNotEmpty(e.getSourceId())) {
                    target.setSourceId(e.getSourceId());
                    UserInf u = userInf.findUser(e.getUserId());
                    target.setUserName(u.getUserName());
                }
                
                ou.getUnitTest().add(target);

            });

            ou.setTeamScore(ou.getUnitTest().stream().mapToLong(s -> s.getScore()).sum());
            ou.setClear(ou.getUnitTest().stream().filter(s->s.getStatus().equals("1")).count());
            ou.setError(ou.getUnitTest().stream().filter(s->s.getStatus().equals("9")).count());
            ou.setWait(ou.getUnitTest().stream().filter(s->s.getStatus().equals("0")).count());
            ou.setWarn(ou.getUnitTest().stream().filter(s->s.getStatus().equals("2")).count());
            result.add(ou);

        });

        return result;
    }

    private boolean isAuth(TeamInf t, long scope) {

        if (t.getAccess().equals("0")) {
            return true;
        }
        for (String a : t.getAccess().split(",")) {
            if (a.equals(String.valueOf(scope))) {
                return true;
            }
        }
        return false;

    }

    public RecordOutput findDetail() {
        return new RecordOutput();
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
