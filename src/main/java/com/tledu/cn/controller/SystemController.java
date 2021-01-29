package com.tledu.cn.controller;

import com.tledu.cn.pojo.Manager;
import com.tledu.cn.pojo.Menu;
import com.tledu.cn.pojo.Student;
import com.tledu.cn.pojo.User;
import com.tledu.cn.service.SystemService;
import com.tledu.cn.util.PageUtils;
import com.tledu.cn.util.RedisUtil;
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
public class SystemController {



    @Autowired
    private SystemService systemService;

   /* @Autowired
    private RedisUtil redisUtil;*/

    /*@RequestMapping("/test1")
    @ResponseBody
    public void test1(){

        List<User> userList = (List<User>) redisUtil.get("userList");
        for (User user : userList) {
            System.out.println(user);
        }
    }*/










    /**
     * 管理员注册
     * @return
     */
    @RequestMapping("/managerRegist")
    @ResponseBody
    public HashMap<String,Object> managerRegist(@RequestBody Manager manager){
        HashMap<String,Object> result=new HashMap<>();
        boolean flag=systemService.managerRegist(manager);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }
    /**
     * 管理员登录
     * @param manager
     * @return
     */
    @RequestMapping("/managerLogin")
    @ResponseBody
    public Manager managerLogin(@RequestBody Manager manager){
        System.out.println(manager);

        Manager manager1=systemService.managerLogin(manager);
        return manager1;
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/findAllUser")
    @ResponseBody
    public PageUtils findAllUser(@RequestBody Map<String,Object> params){
        System.out.println(params);
        PageUtils pageUtils=systemService.findAllUser(params);
        return pageUtils;

    }

    /**
     * 启用用户
     * @param u_id
     * @return
     */
    @RequestMapping("/openUser")
    @ResponseBody
    public HashMap<String,Object> openUser(String u_id){
        HashMap<String,Object> result=new HashMap<>();
        boolean flag=systemService.openUser(u_id);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }

    /**
     * 禁用用户
     * @param u_id
     * @return
     */
    @RequestMapping("/closeUser")
    @ResponseBody
    public HashMap<String,Object> closeUser(String u_id){
        HashMap<String,Object> result=new HashMap<>();
        boolean flag=systemService.closeUser(u_id);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }

    /**
     * 删除用户
     * @param u_id
     * @return
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public HashMap<String,Object> deleteUser(String u_id){
        HashMap<String,Object> result=new HashMap<>();
        boolean flag=systemService.deleteUser(u_id);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }

    /**
     * 模糊查询用户
     * @param params
     * @return
     */
    @RequestMapping("/fuzzySearchUser")
    @ResponseBody
    public PageUtils fuzzySearchUser(@RequestBody Map<String,Object> params){
        return systemService.fuzzySearchUser(params);
    }

    /**
     * 查询所有菜单
     * @param params
     * @return
     */
    @RequestMapping("/findAllMenu")
    @ResponseBody
    public PageUtils findAllMaenu(@RequestBody Map<String,Object> params){

        return systemService.findAllMaenu(params);
    }

    /**
     * 查询所有菜单
     * @return
     */
    @RequestMapping("/findAllMenu1")
    @ResponseBody
    public List<Menu> findAllMaenu1(){

        List<Menu> allMenu = systemService.findAllMenu1();
        return allMenu;
    }


    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @RequestMapping("/addMenu")
    @ResponseBody
    public HashMap<String,Object> addMenu(@RequestBody Menu menu){
       // System.out.println(menu);
        HashMap<String,Object> result = new HashMap<>();
        boolean flag=systemService.addMenu(menu);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }

    /**
     * 删除菜单
     * @param menu_id
     * @return
     */
    @RequestMapping("/deleteMenu")
    @ResponseBody
    public HashMap<String,Object> deleteMenu(String menu_id){
        HashMap<String,Object> result = new HashMap<>();
        boolean flag=systemService.deleteMenu(menu_id);
        if(flag){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }
}
