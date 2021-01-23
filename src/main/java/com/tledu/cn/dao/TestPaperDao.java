package com.tledu.cn.dao;

import com.tledu.cn.pojo.TestPaper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestPaperDao {
    /**
     * 查询所有试卷
     * @return
     */
    public List<TestPaper> findAllTestPaper(String u_id);


    /**
     * 添加试卷
     * @return
     */
    public int addTestPaper(TestPaper testPaper);


    /**
     * 删除试卷
     * @return
     */
    public int delTestPaper(String t_id);


    /**
     * 修改试卷信息
     * @return
     */
    public int updateTestPaper(TestPaper testPaper);
}
