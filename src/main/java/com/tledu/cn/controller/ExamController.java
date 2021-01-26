package com.tledu.cn.controller;

import com.tledu.cn.pojo.Student;
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

    @RequestMapping("/stuLogin")
    @ResponseBody
    //查询题库所有试题
    public Student stuLogin(Student student) {
        // System.out.println(student);
        return examService.studentRegist(student);
    }
}
