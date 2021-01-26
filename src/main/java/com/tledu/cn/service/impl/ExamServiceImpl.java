package com.tledu.cn.service.impl;

import com.tledu.cn.dao.ExamDao;
import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.TestPaper;
import com.tledu.cn.service.ExamService;
import com.tledu.cn.util.JDK8DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;

    @Override
    public Student studentRegist(Student student) {
        Student student1 = null;
        TestPaper testPaper = examDao.selectTestPaper(student.getT_id());
        // System.out.println(student);
        //System.out.println(testPaper);
        if (student.getStu_checkNum().equals(testPaper.getT_checkNum())) {
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


}



