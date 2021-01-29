package com.tledu.cn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tledu.cn.dao.SystemDao;
import com.tledu.cn.pojo.Manager;
import com.tledu.cn.pojo.Menu;
import com.tledu.cn.pojo.QuestionBank;
import com.tledu.cn.pojo.User;
import com.tledu.cn.service.SystemService;
import com.tledu.cn.util.JDK8DateUtil;
import com.tledu.cn.util.PageUtils;
import com.tledu.cn.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemDao systemDao;


    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean managerRegist(Manager manager) {
        manager.setM_id(UUID.randomUUID().toString());
        LocalDateTime now = LocalDateTime.now();
        String time2String = JDK8DateUtil.LocalDateTime2String(now, "yyyy-MM-dd HH:mm:ss");
        manager.setM_createTime(time2String);
        manager.setM_isdelete(0);
        boolean result=false;
        int i=systemDao.managerRegist(manager);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public Manager managerLogin(Manager manager) {

        return systemDao.managerLogin(manager);
    }

    @Override
    public PageUtils findAllUser(Map<String,Object> params) {

        List<User> users = systemDao.findAllUser();
        //分页核心代码
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()),Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<User> pageInfo=new PageInfo<>(users);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }

    @Override
    public boolean openUser(String u_id) {
        boolean result=false;
        int i=systemDao.openUser(u_id);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean closeUser(String u_id) {
        boolean result=false;
        int i=systemDao.closeUser(u_id);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean deleteUser(String u_id) {
        boolean result=false;
        int i=systemDao.deleteUser(u_id);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public PageUtils fuzzySearchUser(Map<String,Object> params) {
        List<User> users=systemDao.fuzzySearchUser(params.get("u_username").toString());
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()),Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<User> pageInfo=new PageInfo<>(users);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }

    @Override
    public PageUtils findAllMaenu(Map<String, Object> params) {
        List<Menu> menuList=systemDao.findAllMenu();
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()),Integer.parseInt(params.get("pageNumber").toString()));
        PageInfo<Menu> pageInfo=new PageInfo<>(menuList);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());

    }

    @Override
    public List<Menu> findAllMenu1() {
        List<Menu> menuList = (List<Menu>) redisUtil.get("menuList");
        if(menuList==null){
            List<Menu> menuList1=menuList1= systemDao.findAllMenu();
            redisUtil.set("menuList",menuList1);
            return menuList1;
        }else {
            System.out.println("从redis中查询");
            return  menuList;
        }

    }

    @Override
    public boolean addMenu(Menu menu) {
        boolean result=false;
        menu.setMenu_id(UUID.randomUUID().toString());
        menu.setMenu_isdelete(0);
        String time2String = JDK8DateUtil.LocalDateTime2String(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");
        menu.setMenu_createTime(time2String);
        int i=systemDao.addMenu(menu);
        List<Menu> allMenu = systemDao.findAllMenu();
        redisUtil.set("menuList",allMenu);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean deleteMenu(String menu_id) {
        boolean result=false;

        int i=systemDao.deleteMenu(menu_id);
        List<Menu> allMenu = systemDao.findAllMenu();
        redisUtil.set("menuList",allMenu);
        if(i>0){
            result=true;
        }
        return result;
    }


}
