package com.example.todo.domain.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.app.common.handler.JavaFileHandler;
import com.example.todo.app.mapper.LabMapper;
import com.example.todo.domain.model.Content;
import com.example.todo.domain.model.Lab;
import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.repository.LabRepository;
import com.example.todo.domain.repository.QuesRepository;
import com.example.todo.domain.repository.UnitTestRepository;

@Service
@Transactional
public class UnitTestServiceImpl {

    @Inject
    UnitTestRepository repository;

    @Inject
    LabRepository lab;

    @Inject
    QuesRepository ques;
    
    @Value("${unit.test.path}")
    private String path;

    public List<Lab> findTittle() {
        return lab.findAll();
    }

    public List<Content> findQues(long input) {
        return ques.findContents(input);
    }

    public Content findDetail(String a) {
        return ques.findDetail(a);
    }

    public UnitTest execute(LabMapper input, String quesNum, String userId) {

        try {
            /* レコード新規作成 */
            UnitTest entity = new UnitTest();
            entity.setQuesNum(quesNum);
            // InputStream is = IOUtils.toInputStream(input.getContext(), "UTF-8");
            byte[] is = input.getContext().getBytes("UTF-8");
            entity.setSource(is);
            entity.setSize(is.length);
            entity.setSaveTime(new Date());
            entity.setUserId(userId);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = dateFormat.format(entity.getSaveTime());
            entity.setStrSaveTime(strDate);

            String y = String.valueOf(Calendar.getInstance().get(
                    Calendar.YEAR));
            String m = String.format("%02d", Calendar.getInstance().get(
                    Calendar.MONTH) + 1);
            String sourceId = y + m + String.format("%07d", repository.nextNum(
                    y));
            entity.setSourceId(sourceId);

            repository.create(entity);

            JavaFileHandler fl = new JavaFileHandler(path + entity
                    .getUserId() + "/" + sourceId + "/");
            fl.create(input.getContext().getBytes());

            return entity;

        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public Collection<UnitTest> findAll() {
        return repository.findAll();
    }

    public List<UnitTest> findBySnum(String userId, String quesNum) {
        return repository.findBySnum(userId, quesNum);
    }

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
