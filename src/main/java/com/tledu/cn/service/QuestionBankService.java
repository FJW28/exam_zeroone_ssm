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

    /**
     * 修改单选题
     * @param questionBank
     * @return
     */
    public boolean updateSingleChoice(QuestionBank questionBank);

    /**
     * 修改简答题
     * @param questionBank
     * @return
     */
    public boolean updateBriefAnswer(QuestionBank questionBank);

    /**
     * 查询全部单选题
     * @param params<String,Object> params
     * @return
     */
    public PageUtils findAllSingleChoice(Map<String,Object> params);

    /**
     * 查询全部简答题
     * @param params<String,Object> params
     * @return
     */
    public PageUtils findAllBriefAnswer(Map<String,Object> params);


    /**
     * 模糊查询
     * @param params
     * @return
     */
    public PageUtils fuzzySearch(Map<String, Object> params);

    /**
     * 批量删除
     * @param idList
     * @return
     */
    public boolean batchDelete(List<String> idList);
}
