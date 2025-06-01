package com.example.todo.domain.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.app.common.handler.JavaFileHandler;
import com.example.todo.app.mapper.LabMapper;
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
public class UnitTestServiceImpl {

    @Inject
    UnitTestRepository repository;

    @Inject
    LabRepository lab;

    @Inject
    QuesRepository ques;
    
    @Inject
    UserInfRepository userInf;

    @Inject
    TeamInfRepository teamInf;

    @Value("${unit.test.path}")
    private String path;

    public List<Lab> findTittle(String userId) {
        UserInf u = userInf.findUser(userId);
        TeamInf t = teamInf.findTeamName(u.getTeamId());
        List<Lab> a = lab.findAll(t.getAccess());
        return a;
    }

    public List<Content> findQues(long input) {
        return ques.findContents(input);
    }

    public Content findDetail(String quesNum) {
        return ques.findDetail(quesNum);
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

    public List<UnitTest> findBySnum(String userId, String quesNum) {
        return repository.findBySnum(userId, quesNum);
    }

}
