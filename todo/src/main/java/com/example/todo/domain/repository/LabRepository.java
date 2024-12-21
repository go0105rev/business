package com.example.todo.domain.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.example.todo.domain.model.Lab;

@Repository
public class LabRepository implements LabRepos {

    private static final Map<String, Lab> maps = new ConcurrentHashMap<String, Lab>();
    static {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        try {

            Lab c1 = new Lab(1, "博物館大冒険", sdf.parse("20241208"),0);
            Lab c2 = new Lab(2, "オフィス危機", sdf.parse("20241208"),0);
            Lab c3 = new Lab(3, "水族館デート", sdf.parse("20241208"),0);
            Lab c4 = new Lab(4, "遊園地うろうろ", sdf.parse("20241208"),0);
            maps.put(String.valueOf(c1.getScope()), c1);
            maps.put(String.valueOf(c2.getScope()), c2);
            maps.put(String.valueOf(c3.getScope()), c3);
            maps.put(String.valueOf(c4.getScope()), c4);
            

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Lab> findAll() {
        return maps.values();
    }

    @Override
    public List<Lab> findLab() {
        List<Lab> result = new ArrayList<>();
        for (Lab c : maps.values()) {
            long q = 0;
            if (c.getScope() == q) {
                ;
            } else {
                q = c.getScope();
                Lab t = new Lab();
                t.setScopeName(c.getScopeName());
                t.setScope(q);
                result.add(t);
            }
        }

        return result;
    }

}
