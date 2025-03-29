package com.example.todo.domain.service;

import java.util.List;

import jakarta.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.repository.QuesRepository;
import com.example.todo.domain.repository.UnitTestRepository;
import com.example.todo.domain.repository.UserInfRepository;

@Service
public class MenuServiceImpl {

    @Inject
    UnitTestRepository repository;
    
    @Inject
    QuesRepository content;
    
    @Inject
    UserInfRepository userInf;

    public List<UnitTest> findAll() {
        return repository.findAll();
    }

    public UnitTestOutput findSource(String quesNum, String sourceId) {

        UnitTest v = repository.findSource(sourceId);
        

        UnitTestOutput result = new UnitTestOutput();
        String a = IOUtils.toString(v.getSource(), "UTF-8");
        result.setSource(a);
        result.setSourceId(sourceId);
        result.setScore(v.getScore());
        result.setDuration((long) v.getDuration());
        result.setSize((long) v.getSize());
        result.setQuesNum(quesNum);
        result.setUserName(userInf.findUser(v.getUserId()).getUserName());
        String name = content.findDetail(quesNum).getQuesName();
        result.setQuesName(name);

        if (v.getStatus() == 0) {
            result.setStatus("評価中");
        } else if (v.getStatus() == 1) {
            result.setStatus("全クリア");
        } else if (v.getStatus() == 2) {
            result.setStatus("一部クリア");
        } else {
            result.setStatus("異常");
        }

        return result;
    }
}
