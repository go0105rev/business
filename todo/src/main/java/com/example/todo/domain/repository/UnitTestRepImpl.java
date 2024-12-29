package com.example.todo.domain.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.example.todo.domain.model.UnitTest;

@Repository
public class UnitTestRepImpl implements UnitTestRepository{
    // public class UnitTestRepImpl implements UnitTestRepository {

    private static final Map<String, UnitTest> Maps = new ConcurrentHashMap<String, UnitTest>();

    @Override
    public Collection<UnitTest> findAll() {
        return Maps.values();
    }

    @Override
    public List<UnitTest> findBySnum(String userId, String quesNum) {
        List<UnitTest> result = new ArrayList<>();
        Maps.entrySet().forEach(v->{
            if(v.getValue().getQuesNum().equals(quesNum) && v.getValue().getUserId().equals(userId)) {
                result.add(v.getValue());
            }
        });
        return result;
    }

    @Override
    public boolean isSourceNum(String sNum) {
        return Maps.containsKey(sNum);
    }

    @Override
    public void create(UnitTest entity) {
        StringBuilder sbl = new StringBuilder();
        sbl.append(entity.getUserId()).append(entity.getQuesNum()).append(":").append(entity.getSaveTime());
        Maps.put(sbl.toString(), entity);
    };

    @Override
    public void updateBySnum(long version, String userId, String quesNum) {

        Maps.forEach((k,v) ->{
            if(k.startsWith(userId+quesNum)) {
                v.setVersion(version);
            }
        });
    }


}
