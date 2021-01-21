package com.tledu.cn.service;

import com.tledu.cn.pojo.BriefAnswer;
import com.tledu.cn.pojo.QuestionBank;
import com.tledu.cn.pojo.SingleChoice;

import java.util.List;

public interface QuestionBankService {
    //查询所有选择题
    public List<SingleChoice> findSingleChoice();

    //查询所有简答题
    public List<BriefAnswer> findBriefAnwser();

    //添加选择题
    public boolean addSingleChoice(SingleChoice singleChoice);

    public boolean addBriefAnswer(BriefAnswer briefAnswer);

    public boolean deleteTopic(String type,String id);
}
