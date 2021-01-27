package com.tledu.cn.service;

import com.tledu.cn.pojo.PageBean;
import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.StudentAnswer;
import com.tledu.cn.pojo.TestQuestionBank;

public interface ExamService {

    /**
     *考生登录
     * @param student
     * @return
     */
    public Student studentRegist(Student student);

    /**
     *查询出试卷的试题
     * @param currentPage
     * @param pageSize
     * @param t_id
     * @return
     */
    public PageBean<TestQuestionBank> selectExam(Integer currentPage, Integer pageSize,String t_id);

    /**
     * 存储考生答案
     * @param studentAnswer
     */
    public boolean saveStuAnswer(StudentAnswer studentAnswer);

    /**
     * 计算分数
     *
     */
    public Student calculatedScore(Student student);
}
