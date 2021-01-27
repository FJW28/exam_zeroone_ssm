package com.tledu.cn.controller;

import com.tledu.cn.pojo.PageBean;
import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.TestQuestionBank;
import com.tledu.cn.service.ExamService;
import com.tledu.cn.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ExamController {
    @Autowired
    private ExamService examService;


    /**
     *考生登录
     * @param student
     * @return
     */
    @RequestMapping("/stuLogin")
    @ResponseBody
    public Student stuLogin(@RequestBody Student student) {
        Student student1 = examService.studentRegist(student);
        if (student1==null){
            return new Student();
        }else {
            return student1;
        }

    }

    @RequestMapping("/selectExam")
    @ResponseBody
    public PageBean<TestQuestionBank> selectExam(String t_id,String currentPage){
       // System.out.println(currentPage);
        int currentPage1 = Integer.parseInt(currentPage);
        PageBean<TestQuestionBank> allByPage = examService.selectExam(currentPage1, 1, t_id);
        return allByPage;
    }
}
