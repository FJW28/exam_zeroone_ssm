package com.tledu.cn.controller;

import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.TestAndAnswer;
import com.tledu.cn.pojo.TestPaper;
import com.tledu.cn.pojo.User;
import com.tledu.cn.service.TestPaperService;
import com.tledu.cn.util.PageUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestPaperController {
    @Autowired
    private TestPaperService testPaperService;

    @RequestMapping("/findAllTestPaper")
    @ResponseBody
    //查询所有试卷
    public PageUtils findAllTestPaper(@RequestBody Map<String, Object> params) {
        return testPaperService.findAllTestPaper(params);
    }

    @RequestMapping("/addTestPaper")
    @ResponseBody
    //添加试卷
    public HashMap<String, Object> addTestPaper(@RequestBody TestPaper testPaper) {
        //System.out.println(testPaper);
        String t_startTime = testPaper.getT_startTime();
        String replace_t_startTime = t_startTime.replace("T", " ");
        String t_endTime = testPaper.getT_endTime();
        String replace_t_endTime = t_endTime.replace("T", " ");
        testPaper.setT_startTime(replace_t_startTime);
        testPaper.setT_endTime(replace_t_endTime);
        HashMap<String, Object> result = new HashMap<>();
        boolean flag = testPaperService.addTestPaper(testPaper);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }

    @RequestMapping("/deleteTestPaper")
    @ResponseBody
    //删除试卷试卷
    public HashMap<String, Object> delTestPaper(String t_id){
        HashMap<String, Object> result = new HashMap<>();
        boolean flag=testPaperService.delTestPaper(t_id);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        System.out.println(result+"deleteTestPaper");
        return result;
    }


    @RequestMapping("/updateTestPaper")
    @ResponseBody
    //修改试卷信息
    public HashMap<String, Object> updateTestPaper(@RequestBody TestPaper testPaper){

        HashMap<String, Object> result = new HashMap<>();
        boolean flag=testPaperService.updateTestPaper(testPaper);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }

    /**
     * 往试卷添加试题
     * @return
     */
    @RequestMapping("/addTopicToTestPaper")
    @ResponseBody
    public HashMap<String,Object> addTopicToTestPaper(String t_id,String q_id){

        HashMap<String,Object> result=new  HashMap<String,Object>();
        boolean flag=testPaperService.addTopicToTestPaper(t_id,q_id);
        if(flag){
            result.put("mark","1");
        }else{
            result.put("mark","0");
        }

        return result;
    }

    /**
     * 批量添加
     * @param //idList
     * @param //t_id
     * @return
     */
    @RequestMapping("/addTopicToTestPaperBybatch")
    @ResponseBody
    public HashMap<String,Object> addTopicToTestPaperBybatch(String idList,String t_id){

        List<String> idlist1=new ArrayList<String>();

        String[] split = idList.split(",");
        for (String s : split) {
            idlist1.add(s);
        }
        HashMap<String,Object> result=new  HashMap<String,Object>();
        boolean flag=testPaperService.addTopicToTestPaperBybach(idlist1,t_id);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }

    /**
     * 查询试卷下的所有试题
     * @param params
     * @return
     */
    @RequestMapping("/findAllTestQuestionBank")
    @ResponseBody
    public PageUtils findAllTestQuestionBank(@RequestBody Map<String,Object> params){
     //   System.out.println(params);
        return testPaperService.findAllTestQuestionBank(params);
    }


    /**
     * 开启试卷
     * @param t_id
     * @return
     */
    @RequestMapping("/openTestPaper")
    @ResponseBody
    public HashMap<String,Object> openTestPaper(String t_id){
      //  System.out.println(t_id);
        HashMap<String,Object> result=new  HashMap<String,Object>();
        boolean flag=testPaperService.openTestPaper(t_id);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }

    /**
     * 从试卷中删除试题
     * @param tq_id
     * @return
     */
    @RequestMapping("/deleteTopicFromTestPaper")
    @ResponseBody
    public HashMap<String,Object> deleteTopicFromTestPaper(String tq_id){
      //  System.out.println(tq_id);
        HashMap<String,Object> result=new  HashMap<String,Object>();
        boolean flag=testPaperService.deleteTopicFromTestPaper(tq_id);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }

        return result;
    }

    /**
     * 从试卷中批量删除试题
     * @param// tq_id
     * @return
     */
    @RequestMapping("/deleteTopicFromTestPaperByBach")
    @ResponseBody
    public HashMap<String,Object> deleteTopicFromTestPaperByBach(String idList){

        String[] split = idList.split(",");
        List<String> idList1=new ArrayList<>();
        for (String s : split) {
            idList1.add(s);
        }
        HashMap<String,Object> result=new  HashMap<String,Object>();
        boolean flag=testPaperService.deleteTopicFromTestPaperByBach(idList1);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }

        return result;
    }

    /**
     * 回显试卷信息
     * @param// q_id
     * @return TestPaper
     */
    @RequestMapping("/findTestPaperURl")
    @ResponseBody
    public TestPaper findTestPaperURl(String t_id){
        System.out.println(t_id);

        return testPaperService.findTestPaperURl(t_id);
    }

    /**
     * 查询试卷考试成绩
     * @param params
     * @return
     */
    @RequestMapping("/queryScore")
    @ResponseBody
    public PageUtils queryScore(@RequestBody Map<String,Object> params){
        System.out.println(params);
        PageUtils students=testPaperService.queryScore(params);
        return students;
    }


    /**
     * 查询试题与考生的答案
     * @param params
     * @return
     */
    @RequestMapping("/testAndAnswer")
    @ResponseBody
    public PageUtils testAndAnswer(@RequestBody Map<String,Object> params){
        System.out.println(params);
        PageUtils pageUtils=testPaperService.testAndAnswer(params);
       // System.out.println(pageUtils);
        return pageUtils;
    }

}
