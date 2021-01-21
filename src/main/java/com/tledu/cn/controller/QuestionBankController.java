package com.tledu.cn.controller;

import com.tledu.cn.pojo.BriefAnswer;
import com.tledu.cn.pojo.QuestionBank;
import com.tledu.cn.pojo.SingleChoice;
import com.tledu.cn.pojo.User;
import com.tledu.cn.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class QuestionBankController {
    @Autowired
    private QuestionBankService questionBankService;

    @RequestMapping("/findAllSingleChoice")
    @ResponseBody
    //查询题库所有试题
    public List<SingleChoice> findAllSingleChoice(){

        return questionBankService.findSingleChoice();
    }

    @RequestMapping("/findAllBriefAnwser")
    @ResponseBody
    //查询题库所有试题
    public List<BriefAnswer> findAllBriefAnwser(){

        return questionBankService.findBriefAnwser();
    }

    @RequestMapping("/addSingleChoice")
    @ResponseBody
    public HashMap<String, Object> addSingleChoice(@RequestBody SingleChoice singleChoice) {
        HashMap<String, Object> result = new HashMap<>();
        boolean flag = questionBankService.addSingleChoice(singleChoice);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }

    @RequestMapping("/addBriefAnswer")
    @ResponseBody
    public HashMap<String, Object> addBriefAnswer(@RequestBody BriefAnswer briefAnswer) {
        HashMap<String, Object> result = new HashMap<>();
        boolean flag = questionBankService.addBriefAnswer(briefAnswer);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }


    @RequestMapping("/deleteTopic")
    @ResponseBody
    public HashMap<String, Object> deleteTopic(String type,String id) {
        System.out.println(type);
        System.out.println(id);
        HashMap<String, Object> result = new HashMap<>();
        boolean flag = questionBankService.deleteTopic(type,id);
        if (flag) {
            result.put("mark", "1");
        } else {
            result.put("mark", "0");
        }
        return result;
    }
}
