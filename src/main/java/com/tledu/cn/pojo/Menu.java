package com.tledu.cn.pojo;

import java.io.Serializable;

public class Menu implements Serializable {

    private  String menu_id;
    private String menu_name;
    private String menu_level;
    private int menu_isdelete;
    private String menu_createTime;

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_level() {
        return menu_level;
    }

    public void setMenu_level(String menu_level) {
        this.menu_level = menu_level;
    }

    public int getMenu_isdelete() {
        return menu_isdelete;
    }

    public void setMenu_isdelete(int menu_isdelete) {
        this.menu_isdelete = menu_isdelete;
    }

    public String getMenu_createTime() {
        return menu_createTime;
    }

    public void setMenu_createTime(String menu_createTime) {
        this.menu_createTime = menu_createTime;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id='" + menu_id + '\'' +
                ", menu_name='" + menu_name + '\'' +
                ", menu_level='" + menu_level + '\'' +
                ", menu_isdelete=" + menu_isdelete +
                ", menu_createTime='" + menu_createTime + '\'' +
                '}';
    }
}
