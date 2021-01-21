package com.tledu.cn.pojo;

public class User {

    private String u_id;    //用户id
    private String u_phone;     //用户手机号
    private String u_password;  //用户密码
    private String u_username;  //用户名
    private int u_status;   //用户状态，0启用，1禁用
    private int u_isdelete;     //账号是否被删除，0否1是
    private String u_createTime;    //创建时间

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_username() {
        return u_username;
    }

    public void setU_username(String u_username) {
        this.u_username = u_username;
    }

    public int getU_status() {
        return u_status;
    }

    public void setU_status(int u_status) {
        this.u_status = u_status;
    }

    public int getU_isdelete() {
        return u_isdelete;
    }

    public void setU_isdelete(int u_isdelete) {
        this.u_isdelete = u_isdelete;
    }

    public String getU_createTime() {
        return u_createTime;
    }

    public void setU_createTime(String u_createTime) {
        this.u_createTime = u_createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id='" + u_id + '\'' +
                ", u_phone='" + u_phone + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_username='" + u_username + '\'' +
                ", u_status=" + u_status +
                ", u_isdelete=" + u_isdelete +
                ", u_createTime='" + u_createTime + '\'' +
                '}';
    }
}
