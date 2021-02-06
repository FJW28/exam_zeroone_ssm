package com.tledu.cn.controller;

import com.tledu.cn.pojo.PageBean;
import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.StudentAnswer;
import com.tledu.cn.pojo.TestQuestionBank;
import com.tledu.cn.service.ExamService;
import com.tledu.cn.util.JDK8DateUtil;
import com.tledu.cn.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ExamController {
    @Autowired
    private ExamService examService;


    /**
     * 考生登录
     *
     * @param student
     * @return
     */
    @RequestMapping("/stuLogin")
    @ResponseBody
    public Student stuLogin(@RequestBody Student student) {
        //System.out.println(student+"controller");
        Student student1 = examService.studentRegist(student);
        if (student1 == null) {
            return new Student();
        } else {
            return student1;
        }

    }

    /**
     * 查询试题
     *
     * @param t_id
     * @param currentPage
     * @return
     */
    @RequestMapping("/selectExam")
    @ResponseBody
    public PageBean<TestQuestionBank> selectExam(String t_id, String currentPage) {
        //  System.out.println(t_id);
        int currentPage1 = Integer.parseInt(currentPage);
        PageBean<TestQuestionBank> allByPage = examService.selectExam(currentPage1, 1, t_id);
        System.out.println(allByPage);
        return allByPage;
    }

    /**
     * 保存答案
     *
     * @param //studentAnswer
     */
    @RequestMapping("/saveStuAnswer")
    @ResponseBody
    public HashMap<String, Object> saveStuAnswer(@RequestBody StudentAnswer studentAnswer) {
       // System.out.println(studentAnswer+"controller");
        HashMap<String, Object> result = new HashMap<String, Object>();

        boolean flag = examService.saveStuAnswer(studentAnswer);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        System.out.println(result);
        return result;
    }

    @RequestMapping("/calculatedScore")
    @ResponseBody
    public Student calculatedScore(@RequestBody Student student) {

        Student student1 = examService.calculatedScore(student);
        // System.out.println(student1);
        return student1;
    }

}
