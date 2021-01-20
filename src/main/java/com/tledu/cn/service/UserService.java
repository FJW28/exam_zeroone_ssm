package com.tledu.cn.service;

import com.tledu.cn.pojo.User;

public interface UserService {

    /**
     * 注册
     * @param user
     * @return
     */
    public boolean regist(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

}
