package com.tledu.cn.pojo;

import java.io.Serializable;

public class Manager implements Serializable {

    private String m_id;
    private String m_username;
    private String m_password;
    private int m_isdelete;
    private String m_createTime;

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_username() {
        return m_username;
    }

    public void setM_username(String m_username) {
        this.m_username = m_username;
    }

    public String getM_password() {
        return m_password;
    }

    public void setM_password(String m_password) {
        this.m_password = m_password;
    }

    public int getM_isdelete() {
        return m_isdelete;
    }

    public void setM_isdelete(int m_isdelete) {
        this.m_isdelete = m_isdelete;
    }

    public String getM_createTime() {
        return m_createTime;
    }

    public void setM_createTime(String m_createTime) {
        this.m_createTime = m_createTime;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "m_id='" + m_id + '\'' +
                ", m_username='" + m_username + '\'' +
                ", m_password='" + m_password + '\'' +
                ", m_isdelete='" + m_isdelete + '\'' +
                ", m_createTime='" + m_createTime + '\'' +
                '}';
    }
}
