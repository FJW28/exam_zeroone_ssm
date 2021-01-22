package com.tledu.cn.controller;


import com.tledu.cn.pojo.QuestionBank;
import com.tledu.cn.pojo.User;
import com.tledu.cn.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class QuestionBankController {
    @Autowired
    private QuestionBankService questionBankService;

    @RequestMapping("/findAllQuestionBank")
    @ResponseBody
    //查询题库所有试题
    public List<QuestionBank> findAllQuestionBank(@RequestBody User user){
        System.out.println(user);
        return questionBankService.findAllQuestionBank(user.getU_id());
    }



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


    @RequestMapping("/deleteTopic")
    @ResponseBody
    public HashMap<String, Object> deleteTopic(String id) {
        System.out.println(id);
        HashMap<String, Object> result = new HashMap<>();
        boolean flag = questionBankService.deleteQuestionBank(id);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }
}
