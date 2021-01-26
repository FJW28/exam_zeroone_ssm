package com.tledu.cn.pojo;

public class Student {
    private String stu_id;  //主键id
    private String stu_name;    //考生姓名
    private String stu_phone;   //考生手机号
    private String stu_checkNum;    //考生邀请码
    private int stu_score;  //考生成绩
    private String t_id;    //试卷id
    private int stu_isdelete;   //0未删除1已删除
    private String stu_createTime;  //开始考试时间
    private String stu_finishTime;  //交卷时间

    public Student(String stu_id, String stu_name, String stu_phone, String stu_checkNum, int stu_score, String t_id, int stu_isdelete, String stu_createTime, String stu_finishTime) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_phone = stu_phone;
        this.stu_checkNum = stu_checkNum;
        this.stu_score = stu_score;
        this.t_id = t_id;
        this.stu_isdelete = stu_isdelete;
        this.stu_createTime = stu_createTime;
        this.stu_finishTime = stu_finishTime;
    }

    public Student() {
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_phone() {
        return stu_phone;
    }

    public void setStu_phone(String stu_phone) {
        this.stu_phone = stu_phone;
    }

    public String getStu_checkNum() {
        return stu_checkNum;
    }

    public void setStu_checkNum(String stu_checkNum) {
        this.stu_checkNum = stu_checkNum;
    }

    public int getStu_score() {
        return stu_score;
    }

    public void setStu_score(int stu_score) {
        this.stu_score = stu_score;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public int getStu_isdelete() {
        return stu_isdelete;
    }

    public void setStu_isdelete(int stu_isdelete) {
        this.stu_isdelete = stu_isdelete;
    }

    public String getStu_createTime() {
        return stu_createTime;
    }

    public void setStu_createTime(String stu_createTime) {
        this.stu_createTime = stu_createTime;
    }

    public String getStu_finishTime() {
        return stu_finishTime;
    }

    public void setStu_finishTime(String stu_finishTime) {
        this.stu_finishTime = stu_finishTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id='" + stu_id + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_phone='" + stu_phone + '\'' +
                ", stu_checkNum='" + stu_checkNum + '\'' +
                ", stu_score=" + stu_score +
                ", t_id='" + t_id + '\'' +
                ", stu_isdelete=" + stu_isdelete +
                ", stu_createTime='" + stu_createTime + '\'' +
                ", stu_finishTime='" + stu_finishTime + '\'' +
                '}';
    }
}
