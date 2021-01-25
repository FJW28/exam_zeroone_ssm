package com.tledu.cn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tledu.cn.dao.QuestionBankDao;
import com.tledu.cn.dao.TestPaperDao;
import com.tledu.cn.pojo.QuestionBank;
import com.tledu.cn.pojo.TestPaper;
import com.tledu.cn.pojo.TestQuestionBank;
import com.tledu.cn.service.TestPaperService;
import com.tledu.cn.util.JDK8DateUtil;
import com.tledu.cn.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TestPaperServiceImpl implements TestPaperService {
    @Autowired
    private TestPaperDao testPaperDao;
    @Autowired
    private QuestionBankDao questionBankDao;

    @Override
    public PageUtils findAllTestPaper(Map<String, Object> params) {
        List<TestPaper> testPapers=testPaperDao.findAllTestPaper(params.get("u_id").toString());
        //分页核心代码
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()),Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<TestPaper> pageInfo=new PageInfo<>(testPapers);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }

    @Override
    public boolean addTestPaper(TestPaper testPaper) {
        boolean result = false;
        testPaper.setT_id(UUID.randomUUID().toString());
        testPaper.setT_status(0);
        testPaper.setT_isdelete(0);
        LocalDateTime now = LocalDateTime.now();//创建本地时间对象
        String localDateTimeString = JDK8DateUtil.LocalDateTime2String(now, "yyyy-MM-dd HH:mm:ss");
        testPaper.setT_createTime(localDateTimeString);
        testPaper.setT_checkNum(UUID.randomUUID().toString());
        testPaper.setT_url("目前未知");

        int i=testPaperDao.addTestPaper(testPaper);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean delTestPaper(String t_id) {
        boolean result = false;
        int i = testPaperDao.delTestPaper(t_id);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean updateTestPaper(TestPaper testPaper) {
        boolean result = false;
        int i = testPaperDao.updateTestPaper(testPaper);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean addTopicToTestPaper(String t_id, String q_id) {
        boolean result=false;
        QuestionBank topic = questionBankDao.findTopicByQid(q_id);
        TestQuestionBank testQuestionBank=new TestQuestionBank();
        testQuestionBank.setT_id(t_id);
        testQuestionBank.setTq_id(topic.getQ_id());
        testQuestionBank.setTq_type(topic.getQ_type());
        testQuestionBank.setTq_content(topic.getQ_content());
        testQuestionBank.setTq_a(topic.getQ_a());
        testQuestionBank.setTq_b(topic.getQ_b());
        testQuestionBank.setTq_c(topic.getQ_c());
        testQuestionBank.setTq_d(topic.getQ_d());
        testQuestionBank.setTq_answer(topic.getQ_answer());
        testQuestionBank.setTq_classify(topic.getQ_classify());
        testQuestionBank.setTq_isdelete(0);
        testQuestionBank.setTq_score(topic.getQ_score());
        testQuestionBank.setU_id(topic.getU_id());
        LocalDateTime now = LocalDateTime.now();
        String dateTime2String = JDK8DateUtil.LocalDateTime2String(now, "yyyy-MM-dd HH:mm:ss");
        testQuestionBank.setTq_createTime(dateTime2String);
        int i=testPaperDao.addTopic(testQuestionBank);
        if(i>0){
            result=true;
        }
        return result;
    }
}
