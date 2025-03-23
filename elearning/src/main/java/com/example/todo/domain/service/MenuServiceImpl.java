package com.example.todo.domain.service;

import jakarta.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.repository.UnitTestRepository;

@Service
public class MenuServiceImpl {

    @Inject
    UnitTestRepository repository;

    public UnitTestOutput findSource(String sourceId) {

        UnitTest v = repository.findSource(sourceId);

        UnitTestOutput result = new UnitTestOutput();
        String a = IOUtils.toString(v.getSource(), "UTF-8");
        result.setSource(a);
        result.setSourceId(sourceId);
        result.setScore(v.getScore());
        result.setDuration((long) v.getDuration());
        result.setSize((long) v.getSize());

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
