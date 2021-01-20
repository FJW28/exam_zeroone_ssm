package com.tledu.cn.controller;

import com.tledu.cn.pojo.User;
import com.tledu.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     * json格式字符串
     * @param
     * @return
     */
    @RequestMapping("/regist")
    @ResponseBody
    public HashMap<String,Object> regist(@RequestBody  User user){
        HashMap<String,Object> result=new HashMap<>();
        boolean flag =userService.regist(user);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }



    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String,Object> login(@RequestBody  User user){
        HashMap<String,Object> result=new HashMap<>();
        boolean flag =userService.login(user);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }




}
