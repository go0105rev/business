package com.example.todo.domain.model;

import java.util.Date;

public class Content {

    String quesNum;

    long scope;

    long ques;

    String quesName;

    String detail;

    String rule;

    String input;
    
    String output;
    String input1;
    
    String output1;
    String input2;
    
    String output2;
    Date sdate;

    long acessFlg;

    public Content() {
        super();
    }

    public Content(String quesNum, long scope, long ques, String quesName,
            String detail, String sample, Date sdate, long acessFlg) {
        super();
        this.quesNum = quesNum;
        this.scope = scope;
        this.ques = ques;
        this.quesName = quesName;
        this.detail = detail;
        this.rule = sample;
        this.sdate = sdate;
        this.acessFlg = acessFlg;
    }

    public String getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(String quesNum) {
        this.quesNum = quesNum;
    }

    public long getScope() {
        return scope;
    }

    public void setScope(long scope) {
        this.scope = scope;
    }

    public long getQues() {
        return ques;
    }

    public void setQues(long ques) {
        this.ques = ques;
    }

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String sample) {
        this.rule = sample;
    }

    
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getInput1() {
        return input1;
    }

    public void setInput1(String input1) {
        this.input1 = input1;
    }

    public String getOutput1() {
        return output1;
    }

    public void setOutput1(String output1) {
        this.output1 = output1;
    }

    public String getInput2() {
        return input2;
    }

    public void setInput2(String input2) {
        this.input2 = input2;
    }

    public String getOutput2() {
        return output2;
    }

    public void setOutput2(String output2) {
        this.output2 = output2;
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
