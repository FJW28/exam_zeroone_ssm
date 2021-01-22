package com.tledu.cn.service;


import com.tledu.cn.pojo.QuestionBank;
import com.tledu.cn.util.PageUtils;

import java.util.List;
import java.util.Map;

public interface QuestionBankService {


    /**
     * 查询所有试题
     * @return
     */
    public PageUtils findAllQuestionBank(Map<String,Object> params);



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
    
    public boolean updateSingleChoice(QuestionBank questionBank);

    public boolean updateBriefAnswer(QuestionBank questionBank);
}
