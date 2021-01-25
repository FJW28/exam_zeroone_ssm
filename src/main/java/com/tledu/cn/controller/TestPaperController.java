package com.tledu.cn.controller;

import com.tledu.cn.pojo.TestPaper;
import com.tledu.cn.pojo.User;
import com.tledu.cn.service.TestPaperService;
import com.tledu.cn.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestPaperController {
    @Autowired
    private TestPaperService testPaperService;

    @RequestMapping("/findAllTestPaper")
    @ResponseBody
    //查询所有试卷
    public PageUtils findAllTestPaper(@RequestBody Map<String, Object> params) {
      // System.out.println(params);
        return testPaperService.findAllTestPaper(params);
    }

    @RequestMapping("/addTestPaper")
    @ResponseBody
    //添加试卷
    public HashMap<String, Object> addTestPaper(@RequestBody TestPaper testPaper) {

        //System.out.println(testPaper);
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
      //  System.out.println(t_id);
        HashMap<String, Object> result = new HashMap<>();
        boolean flag=testPaperService.delTestPaper(t_id);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }


    @RequestMapping("/updateTestPaper")
    @ResponseBody
    //修改试卷信息
    public HashMap<String, Object> updateTestPaper(@RequestBody TestPaper testPaper){
        System.out.println(testPaper);
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
//        String t_id="f0837b30-0975-4613-b6ad-79c9df472cc6";
//        String q_id="518b0ca8-33ee-411e-930a-2c1a2bd9aaf9";

//        System.out.println(t_id+q_id);
        HashMap<String,Object> result=new  HashMap<String,Object>();
        boolean flag=testPaperService.addTopicToTestPaper(t_id,q_id);
        if(flag){
            result.put("mark","1");
        }else{
            result.put("mark","0");
        }

        return result;
    }
}
