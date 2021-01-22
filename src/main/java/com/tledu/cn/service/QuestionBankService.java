package com.tledu.cn.service;


import com.tledu.cn.pojo.QuestionBank;

import java.util.List;

public interface QuestionBankService {


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
    public boolean addSingleChoice(QuestionBank questionBank);

    /**
     * 添加简答题
     * @param questionBank
     * @return
     */
    public boolean addBriefAnswer(QuestionBank questionBank);

    /**
     * 删除试题
     * @param id
     * @return
     */
    public boolean deleteQuestionBank(String id);
}
