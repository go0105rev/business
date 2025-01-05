package com.example.todo.domain.junit;

import java.util.List;

public class RunnerOutput {

    private int total;

    private int currect;

    private int fail;

    private int ignore;

    private long cost;

    private List<String> reason;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrect() {
        return currect;
    }

    public void setCurrect(int currect) {
        this.currect = currect;
    }

    public int getFail() {
        return fail;
    }

    public void setFail(int fail) {
        this.fail = fail;
    }

    public int getIgnore() {
        return ignore;
    }

    public void setIgnore(int ignore) {
        this.ignore = ignore;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public List<String> getReason() {
        return reason;
    }

    public void setReason(List<String> reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "RunnerOutput [total=" + total + ", currect=" + currect
                + ", fail=" + fail + ", ignore=" + ignore + ", cost=" + cost
                + ", reason=" + reason + "]";
    }

}
