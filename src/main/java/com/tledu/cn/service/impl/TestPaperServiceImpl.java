package com.tledu.cn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tledu.cn.dao.TestPaperDao;
import com.tledu.cn.pojo.QuestionBank;
import com.tledu.cn.pojo.TestPaper;
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
        return false;
    }
}
