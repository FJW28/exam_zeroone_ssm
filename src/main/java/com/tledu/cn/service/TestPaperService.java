package com.tledu.cn.service;

import com.tledu.cn.pojo.TestPaper;

import com.tledu.cn.util.PageUtils;

import java.util.List;
import java.util.Map;

public interface TestPaperService {
    /**
     *查找所有试卷
     *
     * @param
     * @return
     */
    public PageUtils findAllTestPaper(Map<String, Object> params);

    /**
     * 添加试卷
     *
     * @param
     * @return
     */
    public boolean addTestPaper(TestPaper testPaper);

    /**
     * 删除试卷
     * @param t_id
     * @return
     */
    public boolean delTestPaper(String t_id);

    /**
     * 修改试卷
     * @param testPaper
     * @return
     */
    public boolean updateTestPaper(TestPaper testPaper);

    /**
     * 往试卷添加试题
     * @param t_id
     * @param q_id
     * @return
     */
    public boolean addTopicToTestPaper(String t_id, String q_id);

    /**
     * 批量添加试题
     * @return
     */
    public boolean addTopicToTestPaperBybach(List<String> idList,String t_id);


    /**
     * 查询该试卷下的所有试题
     * @param params
     * @return
     */
    public PageUtils findAllTestQuestionBank(Map<String,Object> params);


    /**
     *
     * 开启试卷
     * @param t_id
     * @return
     */
    public boolean openTestPaper(String t_id);

    /**
     * 从试卷中删除试题
     * @param tq_id
     * @return
     */
    public boolean deleteTopicFromTestPaper(String tq_id);


    /**
     * 批量删除试题
     * @param idList1
     * @return
     */
    public boolean deleteTopicFromTestPaperByBach(List<String> idList1);
}
