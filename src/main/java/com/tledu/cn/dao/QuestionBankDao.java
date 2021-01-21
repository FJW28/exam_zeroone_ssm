package com.tledu.cn.dao;

import com.tledu.cn.pojo.BriefAnswer;
import com.tledu.cn.pojo.SingleChoice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionBankDao {
    //查询所有选择题
    public List<SingleChoice> findAllSingleChoice();
    //查询所有简答题
    public List<BriefAnswer> findAllBriefAnswer();

    public int addSingleChoice(SingleChoice singleChoice);

    public int addBriefAnswer(BriefAnswer briefAnswer);

    public int deleteSingleChoice(SingleChoice singleChoice);

    public int deleteBriefAnswer(BriefAnswer briefAnswer);
}
