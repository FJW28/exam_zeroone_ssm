package com.tledu.cn.service;

import com.tledu.cn.pojo.Manager;
import com.tledu.cn.pojo.Menu;
import com.tledu.cn.util.PageUtils;

import java.util.List;
import java.util.Map;

public interface SystemService {

    /**
     * 管理员注册
     * @param manager
     * @return
     */
    public boolean managerRegist(Manager manager);


    /**
     *管理员登录
     * @param manager
     * @return
     */
    public Manager managerLogin(Manager manager);

    /**
     * 查询所有用户
     * @return
     */
    public PageUtils findAllUser(Map<String,Object> params);


    /**
     * 启用用户
     * @return
     */
    public boolean openUser(String u_id);

    /**
     * 禁用用户
     * @param u_id
     * @return
     */
    public boolean closeUser(String u_id);


    /**
     * 删除用户
     * @param u_id
     * @return
     */
    public boolean deleteUser(String u_id);

    /**
     * 模糊查询用户
     * @param params
     * @return
     */
    public PageUtils fuzzySearchUser(Map<String,Object> params);

    /**
     * 查询所有菜单
     * @param params
     * @return
     */
    public PageUtils findAllMaenu(Map<String, Object> params);

    /**
     * 查询所有菜单
     * @return
     */
    public List<Menu> findAllMenu1();

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    public boolean addMenu(Menu menu);

    /**
     * 删除菜单
     * @param menu_id
     * @return
     */
    public boolean deleteMenu(String menu_id);
}
