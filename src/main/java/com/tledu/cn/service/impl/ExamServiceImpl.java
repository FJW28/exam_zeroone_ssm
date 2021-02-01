package com.tledu.cn.service.impl;

import com.tledu.cn.dao.ExamDao;
import com.tledu.cn.dao.TestPaperDao;
import com.tledu.cn.pojo.*;
import com.tledu.cn.service.ExamService;
import com.tledu.cn.util.JDK8DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;

    @Autowired
    private TestPaperDao testPaperDao;


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
        System.out.println(testQuestionBanks);

        PageBean<TestQuestionBank> pageBean = new PageBean<TestQuestionBank>(testQuestionBanks.size(), currentPage, pageSize, 5);
        //判断是否是最后一页,如果最后一页就显示最后一页的几条，不是最后一页就显示pageSize条
        if (currentPage == pageBean.getTotalPage())
            pageBean.setList(testQuestionBanks.subList((currentPage - 1) * pageSize, testQuestionBanks.size()));
        else
            pageBean.setList(testQuestionBanks.subList((currentPage - 1) * pageSize, (currentPage - 1) * pageSize + pageSize));
        return pageBean;
    }

    @Override
    public boolean saveStuAnswer(StudentAnswer studentAnswer) {
      //  System.out.println(studentAnswer+"service");
        boolean result = false;

        StudentAnswer studentAnswer1 = examDao.findStudentAnswerByTq_id(studentAnswer);
       // System.out.println(studentAnswer1);
        if (studentAnswer1 != null) {
          //  System.out.println("111");
            int i = examDao.updateAnswer(studentAnswer);
            int k = 0;
            int z = 0;
            result=true;
            TestQuestionBank testQuestionBank = testPaperDao.findTopicByTq_id(studentAnswer.getTq_id());
            if (testQuestionBank.getTq_answer().equals(studentAnswer.getSa_answer())) {
                k = examDao.setScore(testQuestionBank.getTq_score(), testQuestionBank.getTq_id());
                //   System.out.println(k+"k");
            } else {
                z = examDao.setScore1(testQuestionBank.getTq_id());
              //  System.out.println(z + "z");
            }
            if (i > 0 && k > 0 && z > 0) {
                result = true;
            }

            //System.out.println(i+"i");

        } else if (studentAnswer1 == null) {
         //   System.out.println("2222");

            studentAnswer.setSa_id(UUID.randomUUID().toString());
            int j = examDao.saveAnswer(studentAnswer);
          //  System.out.println(j+"j");
            int x = 0;

            TestQuestionBank testQuestionBank = testPaperDao.findTopicByTq_id(studentAnswer.getTq_id());
            if (testQuestionBank.getTq_answer().equals(studentAnswer.getSa_answer())) {
                x = examDao.setScore(testQuestionBank.getTq_score(), testQuestionBank.getTq_id());
           //     System.out.println(x+"X");
            }
            if (j > 0 ) {
                result = true;
            }
          //  System.out.println(result+"result");
        }
        return result;
    }

    @Override
    public Student calculatedScore(Student student) {
        LocalDateTime now = LocalDateTime.now();
        String time2String = JDK8DateUtil.LocalDateTime2String(now, "yyyy-MM-dd HH:mm:ss");
        student.setStu_finishTime(time2String);


        List<StudentAnswer> studentAnswers = examDao.calculatedScore(student);
        int score = 0;
        for (StudentAnswer studentAnswer : studentAnswers) {
            score += studentAnswer.getSa_score();
        }
        student.setStu_score(score);
        int l = examDao.setFinishTimeandScore(student);
        System.out.println(l + "l");
        Student student1 = examDao.findStudentById(student);
        return student1;
    }
}



