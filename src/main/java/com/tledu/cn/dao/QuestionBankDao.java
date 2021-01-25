package com.tledu.cn.dao;



import com.tledu.cn.pojo.QuestionBank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionBankDao {


    /**
     * 查询所有试题
     * @return
     */
    public List<QuestionBank> findAllQuestionBank(String u_id);


    /**
     * 查询题库所有试题 是否添加到试卷中
     * @param u_id
     * @return
     */
    public List<QuestionBank> findAllQuestionBank1(String u_id);

    /**
     * 根据q_id查询试题
     * @param q_id
     * @return
     */
    public QuestionBank findTopicByQid(String q_id);

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

    /**
     * 修改单选题
     * @param questionBank
     * @return
     */
    public int updateSingleChoice(QuestionBank questionBank);

    /**
     * 修改简答题
     * @param questionBank
     * @return
     */
    public int updateBriefAnswer(QuestionBank questionBank);

    /**
     * 查询所有单选题
     * @param u_id
     * @return
     */
    public List<QuestionBank> findAllSingleChoice(String u_id);

    /**
     * 查询所有简答题
     * @param u_id
     * @return
     */
    public List<QuestionBank> findAllBriefAnswer(String u_id);

    /**
     * 模糊查询
     * @param
     * @return
     */
    //public List<QuestionBank> fuzzySearch(FuzzySearch fuzzySearch);
    public List<QuestionBank> fuzzySearch(@Param("q_content") String q_content,@Param("u_id") String u_id );

    /**
     * 批量删除
     * @param idList
     * @return
     */
    public int batchDelete(List<String> idList);

    /**
     * 根据idList查询
     * @param idList
     * @return
     */
    public List<QuestionBank> findTopicByQidList(List<String> idList);


    /**
     * 修改试题的添加状态
     * @param q_id
     * @return
     */
    public int updateAddStatus(String q_id);


    public int updateAddStatusByIdList(List<String> idList);
}
