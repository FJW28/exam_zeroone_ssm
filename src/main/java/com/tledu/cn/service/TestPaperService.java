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

    public boolean delTestPaper(String t_id);


    public boolean updateTestPaper(TestPaper testPaper);
}
