package com.tledu.cn.service;

import com.tledu.cn.pojo.TestPaper;
import com.tledu.cn.util.PageUtils;

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

}
