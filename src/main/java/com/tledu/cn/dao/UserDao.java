package com.tledu.cn.dao;

import com.tledu.cn.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    /**
     * 注册
     * @param user
     * @return
     */
    public int regist(User user);

    public User findUser(User user);
}
