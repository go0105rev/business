package com.example.todo.domain.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.todo.app.common.handler.JavaFileHandler;
import com.example.todo.app.mapper.LabMapper;
import com.example.todo.domain.model.Content;
import com.example.todo.domain.model.Lab;
import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.repository.LabRepository;
import com.example.todo.domain.repository.QuesRepository;
import com.example.todo.domain.repository.UnitTestRepository;

@Service
public class UnitTestServiceImpl {

    @Inject
    UnitTestRepository repository;

    @Inject
    LabRepository lab;

    @Inject
    QuesRepository ques;

    public List<Lab> findTittle() {
        return lab.findAll();
    }

    public List<Content> findQues(long input) {
        return ques.findContents(input);
    }

    public Content findDetail(String a) {
        return ques.findDetail(a);
    }

    public UnitTest execute(LabMapper input) {

        try {
            /* レコード新規作成 */
            UnitTest entity = new UnitTest();
            entity.setQuesNum(input.getQuesNum());
            // InputStream is = IOUtils.toInputStream(input.getContext(), "UTF-8");
            byte[] is = input.getContext().getBytes("UTF-8");
            entity.setSource(is);
            entity.setSize(is.length);
            entity.setSaveTime(new Date());
            entity.setUserId(input.getUserId());

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = dateFormat.format(entity.getSaveTime());
            entity.setStrSaveTime(strDate);

            String y = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
            String m = String.format("%02d", Calendar.getInstance().get(Calendar.MONTH)+1);
            String sourceId=y+m+String.format("%07d",repository.nextNum(y));
            entity.setSourceId(sourceId);

            // repository.updateBySnum(1,entity.getUserId(),entity.getQuesNum());

            repository.create(entity);

            JavaFileHandler fl = new JavaFileHandler("\\home\\codeLearn\\"
                    + entity.getUserId() + "\\" + sourceId);
            fl.create(input.getContext().getBytes());

            /* ソーステスト */

            /* テスト結果の更新 */

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

}
