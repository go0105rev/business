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

    /**
     * スコープのアクセス権限。
     * 
     * @return 0:計画中、1:開始、2:終了（公開）、3:終了（非公開）
     */
    public long getAcessFlg() {
        return acessFlg;
    }

    /**
     * スコープのアクセス権限。
     * 
     * @param acessFlg 0:計画中、1:開始、2:終了（公開）、3:終了（非公開）
     */
    public void setAcessFlg(long acessFlg) {
        this.acessFlg = acessFlg;
    }

}
