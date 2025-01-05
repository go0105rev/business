package com.example.todo.domain.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.todo.domain.model.Content;
import com.example.todo.domain.model.TeamInf;
import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.model.UserInf;
import com.example.todo.domain.repository.LabRepository;
import com.example.todo.domain.repository.QuesRepository;
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

    public RecordOutput findAllRecord() {

        RecordOutput ou = new RecordOutput();
        ou.setUnitTest(new ArrayList<>());

        List<UnitTest> a = unitTest.findAll();
        a.forEach(e -> {
            RecordInf target = new RecordInf();
            target.setUserId(e.getUserId());
            target.setQuesNum(e.getQuesNum());
            target.setScore(e.getScore());
            target.setStrSaveTime(e.getStrSaveTime());
            target.setSourceId(e.getSourceId());

            UserInf u = userInf.findUser(target.getUserId());
            target.setUserName(u.getUserName());
            target.setTeamId(u.getTeamId());

            TeamInf t = userInf.findTeamName(target.getTeamId());
            target.setTeamName(t.getTeamName());
            
            Content c=ques.findDetail(target.getQuesNum());
            target.setQuesName(c.getQuesName());
            String scope=lab.findName(c.getScope());
            target.setScopeName(scope);

            ou.getUnitTest().add(target);

        });
        

        return ou;
    }

    public RecordOutput findDetail() {
        return new RecordOutput();
    }

}
