package com.tledu.cn.service.impl;

import com.tledu.cn.dao.QuestionBankDao;

import com.tledu.cn.pojo.QuestionBank;
import com.tledu.cn.service.QuestionBankService;
import com.tledu.cn.util.JDK8DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {
    @Autowired
    //引入dao层
    private QuestionBankDao questionBankDao;

    @Override
    public List<QuestionBank> findAllQuestionBank(String u_id) {
        return questionBankDao.findAllQuestionBank(u_id);
    }


    @Override
    public boolean addSingleChoice(QuestionBank questionBank) {
        boolean result=false;
        questionBank.setQ_id(UUID.randomUUID().toString());
        questionBank.setQ_type("单选题");
        questionBank.setQ_isdelete(0);
        LocalDateTime now = LocalDateTime.now();//创建本地时间对象
        String localDateTimeString = JDK8DateUtil.LocalDateTime2String(now, "yyyy-MM-dd HH:mm:ss");
        questionBank.setQ_createTime(localDateTimeString);
        int i = questionBankDao.addSingleChoice(questionBank);
        if(i>0){
            result=true;
        }
        return result;
    }
    @Override
    public boolean addBriefAnswer(QuestionBank questionBank) {
        boolean result=false;
        questionBank.setQ_id(UUID.randomUUID().toString());
        questionBank.setQ_type("简答题");
        questionBank.setQ_isdelete(0);
        LocalDateTime now = LocalDateTime.now();//创建本地时间对象
        String localDateTimeString = JDK8DateUtil.LocalDateTime2String(now, "yyyy-MM-dd HH:mm:ss");
        questionBank.setQ_createTime(localDateTimeString);
        int i = questionBankDao.addBriefAnswer(questionBank);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean deleteQuestionBank(String id) {
        questionBankDao.deleteQuestionBank(id);
        return false;
    }


}
