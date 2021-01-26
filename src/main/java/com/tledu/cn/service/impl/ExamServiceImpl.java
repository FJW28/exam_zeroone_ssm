package com.tledu.cn.service.impl;

import com.tledu.cn.dao.ExamDao;
import com.tledu.cn.pojo.PageBean;
import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.TestPaper;
import com.tledu.cn.pojo.TestQuestionBank;
import com.tledu.cn.service.ExamService;
import com.tledu.cn.util.JDK8DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;


    @Override
    public Student studentRegist(Student student) {
        Student student1 = null;
        //获取试卷表信息
        TestPaper testPaper = examDao.selectTestPaper(student.getT_id());
        //判断试卷表邀请码和学生邀请码是否一样
        if (student.getStu_checkNum().equals(testPaper.getT_checkNum())) {
            //如果是，添加
            student.setStu_id(UUID.randomUUID().toString());
            LocalDateTime now = LocalDateTime.now();//创建本地时间对象
            String localDateTimeString = JDK8DateUtil.LocalDateTime2String(now, "yyyy-MM-dd HH:mm:ss");
            student.setStu_createTime(localDateTimeString);
            student.setStu_isdelete(0);
            int i = examDao.studentRegist(student);
            if (i > 0) {
                student1 = examDao.studentLogin(student.getStu_id());
            }
        }
        return student1;
    }

    @Override
    public PageBean<TestQuestionBank> selectExam(Integer currentPage, Integer pageSize, String t_id) {
        List<TestQuestionBank> testQuestionBanks = examDao.selectExam(t_id);
        PageBean<TestQuestionBank> pageBean = new PageBean<TestQuestionBank>(testQuestionBanks.size(), currentPage, pageSize, 5);
        //判断是否是最后一页,如果最后一页就显示最后一页的几条，不是最后一页就显示pageSize条
        if(currentPage==pageBean.getTotalPage())
            pageBean.setList(testQuestionBanks.subList((currentPage-1)*pageSize, testQuestionBanks.size()));
        else
            pageBean.setList(testQuestionBanks.subList((currentPage-1)*pageSize, (currentPage-1)*pageSize+pageSize));
        return pageBean;
    }
}



