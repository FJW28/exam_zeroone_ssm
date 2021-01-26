package com.tledu.cn.service;

import com.tledu.cn.pojo.PageBean;
import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.TestQuestionBank;

public interface ExamService {

    /**
     *考生登录
     * @param student
     * @return
     */
    public Student studentRegist(Student student);

    public PageBean<TestQuestionBank> selectExam(Integer currentPage, Integer pageSize,String t_id);
}
