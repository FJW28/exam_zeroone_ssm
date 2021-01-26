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
import java.util.ArrayList;
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
    //    System.out.println(topic+"1111");
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

        int j=questionBankDao.updateAddStatus(q_id);
        int i=testPaperDao.addTopic(testQuestionBank);
        if(i>0&&j>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean addTopicToTestPaperBybach(List<String> idList, String t_id) {
        boolean result=false;
        List<QuestionBank> questionBanks=questionBankDao.findTopicByQidList(idList);
      //  System.out.println(questionBanks+"11111111111");
        List<TestQuestionBank> testQuestionBankList=new ArrayList<>();
        for (QuestionBank topic : questionBanks) {
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
            testQuestionBankList.add(testQuestionBank);

        }

        int i=testPaperDao.addTopicToTestPaperBybach(testQuestionBankList);
    //    System.out.println(idList+"5555555555555");
        int j=questionBankDao.updateAddStatusByIdList(idList);
        if(i>0&&j>0){
            result=true;
        }


        return result;
    }

    @Override
    public PageUtils findAllTestQuestionBank(Map<String, Object> params) {

        List<TestQuestionBank> testQuestionBankList=testPaperDao.findAllTestQuestionBank(params.get("t_id").toString());
        //分页核心代码
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()),Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<TestQuestionBank> pageInfo=new PageInfo<>(testQuestionBankList);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }

    @Override
    public boolean openTestPaper(String t_id) {
        boolean result=false;
        int i=testPaperDao.openTestPaper(t_id);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean deleteTopicFromTestPaper(String tq_id) {
        boolean result=false;
        int i=testPaperDao.deleteTopicFromTestPaper(tq_id);
        int j=questionBankDao.updateAddStatus1(tq_id);
        if(i>0&&j>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean deleteTopicFromTestPaperByBach(List<String> idList1) {
        boolean result=false;
        int i=testPaperDao.deleteTopicFromTestPaperByBach(idList1);
        int j=questionBankDao.updateAddStatusByIdList1(idList1);
        if(i>0&&j>0){
            result=true;
        }
        return result;
    }

    @Override
    public TestPaper findTestPaperURl(String t_id) {
        return testPaperDao.findTestPaperURl(t_id);
    }
}
