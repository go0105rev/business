package com.example.todo.domain.service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.example.todo.app.common.handler.JavaFileHandler;
import com.example.todo.app.mapper.LabMapper;
import com.example.todo.domain.model.Content;
import com.example.todo.domain.model.Lab;
import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.repository.LabRepository;
import com.example.todo.domain.repository.QuesRepository;
import com.example.todo.domain.repository.UnitTestRepImpl;

@Service
public class UnitTestServiceImpl {

    @Inject
    UnitTestRepImpl repository;

    @Inject
    LabRepository lab;

    @Inject
    QuesRepository ques;

    public List<Lab> findTittle() {
        return lab.findLab();
    }

    public List<Content> findQues(long input) {
        return ques.findContent(input);
    }

    public Content findDetail(String a) {
        return ques.findDetail(a);
    }

    public UnitTest execute(LabMapper input) {

        /* レコード新規作成 */
        UnitTest entity = new UnitTest();
        entity.setQuesNum(input.getQuesNum());
        entity.setVersion(0);
        InputStream is = IOUtils.toInputStream(input.getContext(), "UTF-8");
        entity.setSource(is);
        entity.setSaveTime(new Date());
        entity.setUserId(input.getUserId());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(entity.getSaveTime());
        entity.setStrSaveTime(strDate);

        repository.updateBySnum(1,entity.getUserId(),entity.getQuesNum());

        repository.create(entity);

        JavaFileHandler fl = new JavaFileHandler("\\home\\codeLearn\\" + entity
                .getUserId() + "\\" + entity.getQuesNum());
        fl.create(input.getContext().getBytes());

        /* ソーステスト */

        /* テスト結果の更新 */

        return entity;
    }

    public Collection<UnitTest> findAll() {
        return repository.findAll();
    }

    public List<UnitTest> findBySnum(String userId, String quesNum) {
        return repository.findBySnum(userId,quesNum);
    }

}
