package com.example.todo.domain.service;

import java.util.List;

public class RanksOutput {

    private String quesName;
    
    private int cnt;
    
    private List<RankOutput> rankInf;

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public List<RankOutput> getRankInf() {
        return rankInf;
    }

    public void setRankInf(List<RankOutput> rankInf) {
        this.rankInf = rankInf;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    
    
    
}
