package com.example.todo.domain.service;

import com.example.todo.domain.model.UserInf;

public class RankOutput extends UserInf {

    private String rank;

    private Long Score;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Long getScore() {
        return Score;
    }

    public void setScore(Long score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "RankOutput [rank=" + rank + ", Score=" + Score + ", toString()="
                + super.toString() + "]";
    }

}
