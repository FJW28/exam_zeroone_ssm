package com.tledu.cn.controller;


import com.github.pagehelper.PageInfo;
import com.tledu.cn.pojo.QuestionBank;
import com.tledu.cn.pojo.User;
import com.tledu.cn.service.QuestionBankService;
import com.tledu.cn.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.annotation.XmlList;
import javax.xml.ws.RequestWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionBankController {
    @Autowired
    private QuestionBankService questionBankService;

    @RequestMapping("/findAllQuestionBank")
    @ResponseBody
    //查询题库所有试题
    public PageUtils findAllQuestionBank(@RequestBody Map<String, Object> params) {
        // System.out.println(params);
        return questionBankService.findAllQuestionBank(params);
    }


    @RequestMapping("/findAllQuestionBank1")
    @ResponseBody
    //查询题库所有试题 是否添加到试卷中
    public PageUtils findAllQuestionBank1(@RequestBody Map<String, Object> params) {
       // System.out.println(params);
        return questionBankService.findAllQuestionBank1(params);
    }




    /**
     * 添加单选题
     *
     * @param questionBank
     * @return
     */
    @RequestMapping("/addSingleChoice")
    @ResponseBody
    public HashMap<String, Object> addSingleChoice(@RequestBody QuestionBank questionBank) {
        System.out.println(questionBank);
        HashMap<String, Object> result = new HashMap<>();
        boolean flag = questionBankService.addSingleChoice(questionBank);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }

    /**
     * 添加简答题
     *
     * @param questionBank
     * @return
     */
    @RequestMapping("/addBriefAnswer")
    @ResponseBody
    public HashMap<String, Object> addBriefAnswer(@RequestBody QuestionBank questionBank) {
        HashMap<String, Object> result = new HashMap<>();
        boolean flag = questionBankService.addBriefAnswer(questionBank);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }


    /**
     * 删除试题
     *
     * @param q_id
     * @return
     */
    @RequestMapping("/deleteTopic")
    @ResponseBody
    public HashMap<String, Object> deleteTopic(String q_id) {
        System.out.println(q_id);
        HashMap<String, Object> result = new HashMap<>();
        boolean flag = questionBankService.deleteQuestionBank(q_id);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }

    /**
     * 修改单选题
     *
     * @param questionBank
     * @return
     */
    @RequestMapping("/updateSingleChoice")
    @ResponseBody
    public HashMap<String, Object> updateSingleChoice(@RequestBody QuestionBank questionBank) {
        System.out.println(questionBank);
        HashMap<String, Object> result = new HashMap<>();
        boolean flag = questionBankService.updateSingleChoice(questionBank);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }

    /**
     * 修改简答题
     *
     * @param questionBank
     * @return
     */
    @RequestMapping("/updateBriefAnswer")
    @ResponseBody
    public HashMap<String, Object> updateBriefAnswer(@RequestBody QuestionBank questionBank) {
        System.out.println(questionBank);
        HashMap<String, Object> result = new HashMap<>();
        boolean flag = questionBankService.updateBriefAnswer(questionBank);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }

    /**
     * 查询全部单选题
     *
     * @param
     * @return
     */
    @RequestMapping("/findAllSingleChoice")
    @ResponseBody
    public PageUtils findAllSingleChoice(@RequestBody Map<String, Object> params) {
        System.out.println(params);
        return questionBankService.findAllSingleChoice(params);

    }


    /**
     * 查询全部简答题
     *
     * @param
     * @return
     */
    @RequestMapping("/findAllBriefAnswer")
    @ResponseBody
    public PageUtils findAllBriefAnswer(@RequestBody Map<String, Object> params) {
        System.out.println(params);
        return questionBankService.findAllBriefAnswer(params);

    }


    /**
     * 模糊查询
     *
     * @param
     * @return
     */
    @RequestMapping("/fuzzySearch")
    @ResponseBody
    public PageUtils fuzzySearch(@RequestBody Map<String, Object> params) {
       // System.out.println(params);
        return questionBankService.fuzzySearch(params);

    }

    /**
     * 批量删除
     * @param idList
     * @return
     */
    @RequestMapping("/batchDelete")
    @ResponseBody
    public HashMap<String,Object> batchDelete(String idList){
//        System.out.println(idList);
        List<String> idList1=new ArrayList<String>();
        String[] split = idList.split(",");
        for (String s : split) {
            idList1.add(s);
        }

        System.out.println(idList1);
        HashMap<String, Object> result = new HashMap<>();
        boolean flag=questionBankService.batchDelete(idList1);
        if(flag){
            result.put("mark","1");
        }
        else{
            result.put("mark","0");
        }
        return result;
    }


}
