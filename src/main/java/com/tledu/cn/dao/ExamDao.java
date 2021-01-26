package com.tledu.cn.dao;

import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.TestPaper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamDao {
    /**
     *
     * @param t_id
     * @return
     */
    public TestPaper selectTestPaper(String t_id);

    /**
     *
     * @param student
     * @return
     */
    public int studentRegist(Student student);

    /**
     *考生登录
     * @param
     * @return
     */
    public Student studentLogin(String stu_id);
}
