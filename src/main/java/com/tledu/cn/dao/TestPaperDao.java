package com.tledu.cn.dao;

import com.tledu.cn.pojo.TestPaper;
import com.tledu.cn.pojo.TestQuestionBank;
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

    /**
     * 添加试题
     * @param testQuestionBank
     * @return
     */
    public int addTopic(TestQuestionBank testQuestionBank);

    /**
     * 查询试卷下的所有试题
     * @param t_id
     * @return
     */
    public List<TestQuestionBank> findAllTestQuestionBank(String  t_id);

    /**
     * 批量添加试题
     * @param testQuestionBankList
     * @return
     */
    public int addTopicToTestPaperBybach(List<TestQuestionBank> testQuestionBankList);

    /**
     * 开启试卷
     * @param t_id
     * @return
     */
    public int openTestPaper(String t_id);

    /**
     * 从试卷删除试题
     * @param tq_id
     * @return
     */
    public int deleteTopicFromTestPaper(String tq_id);

    /**
     * 从试卷批量删除试题
     * @param idList1
     * @return
     */
    public int deleteTopicFromTestPaperByBach(List<String> idList1);

    /**
     * 回显试卷信息
     * @param// q_id
     * @return TestPaper
     */
    public TestPaper findTestPaperURl(String t_id);
}
