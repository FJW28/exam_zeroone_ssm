package com.tledu.cn.service.impl;

import com.tledu.cn.dao.QuestionBankDao;
import com.tledu.cn.pojo.BriefAnswer;
import com.tledu.cn.pojo.QuestionBank;
import com.tledu.cn.pojo.SingleChoice;
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
    public List<SingleChoice> findSingleChoice() {
        return questionBankDao.findAllSingleChoice();
    }

    @Override
    public List<BriefAnswer> findBriefAnwser() {
        return questionBankDao.findAllBriefAnswer();
    }

    @Override
    public boolean addSingleChoice(SingleChoice singleChoice) {
        boolean result=false;
        singleChoice.setS_id(UUID.randomUUID().toString());
        singleChoice.setS_type("单选题");
        singleChoice.setS_delete(0);
        LocalDateTime now = LocalDateTime.now();//创建本地时间对象
        String localDateTimeString = JDK8DateUtil.LocalDateTime2String(now, "yyyy-MM-dd HH:mm:ss");
        singleChoice.setS_createTime(localDateTimeString);
        int i = questionBankDao.addSingleChoice(singleChoice);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean deleteTopic(String type,String id) {
        boolean result = false;
        if (type.equals("简答题")){
            BriefAnswer briefAnswer=new BriefAnswer();
            briefAnswer.setB_id(id);
            briefAnswer.setB_isdelete(1);
            int i = questionBankDao.deleteBriefAnswer(briefAnswer);
            if(i>0){
                result=true;
            }
        }else {
            SingleChoice singleChoice=new SingleChoice();
            singleChoice.setS_id(id);
            singleChoice.setS_delete(1);
            int i = questionBankDao.deleteSingleChoice(singleChoice);
            if(i>0){
                result=true;
            }
        }

        return result;
    }

    @Override
    public boolean addBriefAnswer(BriefAnswer briefAnswer) {
        boolean result=false;
        briefAnswer.setB_id(UUID.randomUUID().toString());
        briefAnswer.setB_type("简答题");
        briefAnswer.setB_isdelete(0);
        LocalDateTime now = LocalDateTime.now();//创建本地时间对象
        String localDateTimeString = JDK8DateUtil.LocalDateTime2String(now, "yyyy-MM-dd HH:mm:ss");
        briefAnswer.setB_createTime(localDateTimeString);
        int i = questionBankDao.addBriefAnswer(briefAnswer);
        if(i>0){
            result=true;
        }
        return result;
    }
}
