package com.example.todo.domain.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.example.todo.domain.model.Content;

@Repository
public class QuesRepository implements QuesRepos {

    private static final Map<String, Content> maps = new ConcurrentHashMap<String, Content>();
    static {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        try {

            Content c1 = new Content("L001001", 1, 1, "営業開始", "長さ <br>N の英小文字からなる文字列S と英小文字 <br>c1,c2が与えられます。<br>Sの文字のうち<br>c1であるもの以外を全てc2に置き換えた文字列を求めてください。", "1≤N≤100,Nは整数", sdf.parse(
                    "20241208"), 0);
            Content c2 = new Content("L001002", 1, 2, "客ラッシュ", "", "", sdf
                    .parse("20241208"), 0);
            Content c3 = new Content("L001003", 1, 3, "展示物動き出す", "", "", sdf
                    .parse("20241208"), 0);
            Content c4 = new Content("L001004", 1, 4, "警備員転職", "", "", sdf
                    .parse("20241208"), 0);
            Content c5 = new Content("L001005", 1, 5, "リフォーム工事", "", "", sdf
                    .parse("20241208"), 0);
            maps.put(c1.getQuesNum(), c1);
            maps.put(c2.getQuesNum(), c2);
            maps.put(c3.getQuesNum(), c3);
            maps.put(c4.getQuesNum(), c4);
            maps.put(c5.getQuesNum(), c5);

            Content d1 = new Content("L002001", 2, 1, "面積測量", "", "", sdf.parse(
                    "20250105"), 0);
            Content d2 = new Content("L002002", 2, 2, "デスク購入", "", "", sdf
                    .parse("20250105"), 0);
            Content d3 = new Content("L002003", 2, 3, "エレベーター利用", "", "", sdf
                    .parse("20250105"), 0);
            Content d4 = new Content("L002004", 2, 4, "入館証失い", "", "", sdf
                    .parse("20250105"), 0);
            Content d5 = new Content("L002005", 2, 5, "大掃除", "", "", sdf.parse(
                    "20250105"), 0);
            maps.put(d1.getQuesNum(), d1);
            maps.put(d2.getQuesNum(), d2);
            maps.put(d3.getQuesNum(), d3);
            maps.put(d4.getQuesNum(), d4);
            maps.put(d5.getQuesNum(), d5);
            

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Content> findAll() {
        return maps.values();
    }

    @Override
    public List<Content> findContent(long scope) {


        List<String> targetQues = new ArrayList<>();
        maps.forEach((k, v) -> {
            if(v.getScope()==scope) {
                targetQues.add(k);
            }
        });

        Collections.sort(targetQues);

        List<Content> result = new ArrayList<>();
        targetQues.forEach(v->{
            Content c = new Content();
            c.setQuesNum(maps.get(v).getQuesNum());
            c.setQues(maps.get(v).getQues());
            c.setQuesName(maps.get(v).getQuesName());
            result.add(c);
        });
        

        return result;
    };

    @Override
    public Content findDetail(String a) {
        return maps.get(a);
    }

}
