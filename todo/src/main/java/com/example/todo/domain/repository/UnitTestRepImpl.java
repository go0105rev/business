package com.example.todo.domain.repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.example.todo.domain.model.UnitTest;

@Repository
public class UnitTestRepImpl{
//public class UnitTestRepImpl implements UnitTestRepository {

    private static final Map<String, UnitTest> UnitTestMap = new ConcurrentHashMap<String, UnitTest>();

    public Collection<UnitTest> findAll() {
        return UnitTestMap.values();
    }
    
    public UnitTest findBySnum(String sNum) {
        return UnitTestMap.get("sNum");
    }

    public boolean isSourceNum(String sNum) {
        return UnitTestMap.containsKey(sNum);
    }

    public void create(UnitTest entity) {
        UnitTestMap.put(entity.getQuesNum(), entity);
    };
    
    public void updateBySnum(UnitTest entity) {
        UnitTestMap.put(entity.getQuesNum(), entity);
    }

}
