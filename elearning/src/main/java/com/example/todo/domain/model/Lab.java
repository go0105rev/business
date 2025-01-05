package com.example.todo.domain.model;

import java.util.Date;

public class Lab {

    long scope;

    String scopeName;

    Date sdate;

    long acessFlg;

    public Lab() {
        super();
    }

    public Lab(long scope, String scopeName, Date sdate, long acessFlg) {
        super();
        this.scope = scope;
        this.scopeName = scopeName;
        this.sdate = sdate;
        this.acessFlg = acessFlg;
    }

    public long getScope() {
        return scope;
    }

    public void setScope(long scope) {
        this.scope = scope;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public long getAcessFlg() {
        return acessFlg;
    }

    public void setAcessFlg(long acessFlg) {
        this.acessFlg = acessFlg;
    }

}
