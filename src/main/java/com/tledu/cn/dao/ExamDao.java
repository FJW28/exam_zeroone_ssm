package com.tledu.cn.dao;

import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.TestPaper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamDao {
    public TestPaper selectTestPaper(String t_id);

    public int studentRegist(Student student);

    public Student studentLogin(String stu_id);
}
