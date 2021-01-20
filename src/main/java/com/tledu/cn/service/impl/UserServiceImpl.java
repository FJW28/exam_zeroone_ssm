package com.tledu.cn.service.impl;

import com.tledu.cn.dao.UserDao;
import com.tledu.cn.pojo.User;
import com.tledu.cn.service.UserService;
import com.tledu.cn.util.JDK8DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public boolean regist(User user) {
        boolean result=false;
        user.setU_id(UUID.randomUUID().toString());
        LocalDateTime now = LocalDateTime.now();//创建本地时间对象
        String localDateTimeString = JDK8DateUtil.LocalDateTime2String(now, "yyyy-MM-dd HH:mm:ss");
        user.setU_createTime(localDateTimeString);
        user.setU_isdelete(0);
        user.setU_status(0);
        int i = userDao.regist(user);
        if(i>0){
            result=true;
        }
        return result;
    }

    @Override
    public boolean login(User user) {
        boolean result=false;
        User user1=userDao.findUser(user);
        if(user1!=null){
            result=true;
        }
        return result;
    }
}
