package com.example.todo.domain.service;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import jakarta.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.todo.app.welcome.UnitTestInput;
import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.repository.UnitTestRepImpl;

@Service
public class UnitTestServiceImpl {
//public class UnitTestServiceImpl extends BaseService<UnitTestInput, Output>{

    @Inject
    UnitTestRepImpl repository;
    
    public UnitTest execute(UnitTestInput input) {
        
        /*レコード新規作成*/
        UnitTest entity = new UnitTest();
        entity.setQues(input.getQues());
        entity.setScope(input.getScope());
        entity.setUserId("R20240104");
        entity.setSourceNum(UUID.randomUUID().toString());
        entity.setSaveTime(new Date());
        repository.create(entity);
        
        /*ソースのアップロード*/
        
        /*ソーステスト*/

        /*テスト結果の更新*/

        return entity;
    }
    
    public Collection<UnitTest> findAll(){
        return repository.findAll();
    }
}