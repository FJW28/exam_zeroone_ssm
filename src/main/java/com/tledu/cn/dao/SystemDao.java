package com.tledu.cn.dao;

import com.tledu.cn.pojo.Manager;
import com.tledu.cn.pojo.Menu;
import com.tledu.cn.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemDao {

    /**
     * 管理员注册
     * @param manager
     * @return
     */
    public int managerRegist(Manager manager);

    /**
     * 管理员登录
     * @param manager
     * @return
     */
    public Manager managerLogin(Manager manager);

    /**
     * 查找所有用户
     * @return
     */
    public List<User> findAllUser();


    /**
     * 开启用户
     * @param u_id
     * @return
     */
    public int openUser(String u_id);

    /**
     * 禁用用户
     * @param u_id
     * @return
     */
    public int closeUser(String u_id);


    /**
     * 删除用户
     * @param u_id
     * @return
     */
    public int deleteUser(String u_id);

    /**
     * 模糊查询用户
     * @param u_username
     * @return
     */
    public List<User> fuzzySearchUser(String u_username);

    /**
     * 查询所有菜单
     * @return
     */
    public List<Menu> findAllMenu();

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    public int addMenu(Menu menu);

    /**
     * 删除菜单
     * @param menu_id
     * @return
     */
    public int deleteMenu(String menu_id);
}
