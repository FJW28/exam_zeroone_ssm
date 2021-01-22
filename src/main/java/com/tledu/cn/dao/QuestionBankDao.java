package com.tledu.cn.dao;


import com.tledu.cn.pojo.QuestionBank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionBankDao {


    /**
     * 查询所有试题
     * @return
     */
    public List<QuestionBank> findAllQuestionBank(String u_id);


    /**
     * 添加选择题
     * @param questionBank
     * @return
     */
    public int addSingleChoice(QuestionBank questionBank);

    /**
     * 添加简答题
     * @param questionBank
     * @return
     */
    public int addBriefAnswer(QuestionBank questionBank);

    /**
     * 删除试题
     * @param
     * @return
     */
    public int deleteQuestionBank(String id);


}
