package com.tledu.cn.pojo;

import java.util.List;
/*
* 题库实体类
* */
public class QuestionBank {
    private List<SingleChoice> singleChoicesList;   //单选题集合
    private List<BriefAnswer> briefAnswerList;  //简答题集合

    public QuestionBank(List<SingleChoice> singleChoicesList, List<BriefAnswer> briefAnswerList) {
        this.singleChoicesList = singleChoicesList;
        this.briefAnswerList = briefAnswerList;
    }

    public QuestionBank() {
    }

    public List<SingleChoice> getSingleChoicesList() {
        return singleChoicesList;
    }

    public void setSingleChoicesList(List<SingleChoice> singleChoicesList) {
        this.singleChoicesList = singleChoicesList;
    }

    public List<BriefAnswer> getBriefAnswerList() {
        return briefAnswerList;
    }

    public void setBriefAnswerList(List<BriefAnswer> briefAnswerList) {
        this.briefAnswerList = briefAnswerList;
    }

    @Override
    public String toString() {
        return "QuestionBank{" +
                "singleChoicesList=" + singleChoicesList +
                ", briefAnswerList=" + briefAnswerList +
                '}';
    }
}
