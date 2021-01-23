package com.tledu.cn.pojo;

public class TestPaper {
    private String t_id;    //主键id
    private String t_title; //试卷标题
    private String t_classify;  //试卷分类
    private int    t_status;    //试卷状态，0未开启，1已开启
    private int    t_isdelete;  //0未删除，1已删除
    private String t_createTime;    //试卷创建时间
    private String t_checkNum;  //试卷的邀请码
    private String t_url;       //试卷链接
    private String t_startTime;     //开始考试时间
    private String u_id;        //用户id
    private String t_statusStr;
    private String t_endTime;  //考试时长

    public TestPaper(String t_endTime,String t_id, String t_title, String t_classify, int t_status, int t_isdelete, String t_createTime, String t_checkNum, String t_url, String t_startTime, String u_id, String t_statusStr) {
        this.t_id = t_id;
        this.t_title = t_title;
        this.t_classify = t_classify;
        this.t_status = t_status;
        this.t_isdelete = t_isdelete;
        this.t_createTime = t_createTime;
        this.t_checkNum = t_checkNum;
        this.t_url = t_url;
        this.t_startTime = t_startTime;
        this.u_id = u_id;
        this.t_statusStr = t_statusStr;
        this.t_endTime=t_endTime;
    }

    public TestPaper() {
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_endTime() {
        return t_endTime;
    }

    public void setT_endTime(String t_endTime) {
        this.t_endTime = t_endTime;
    }

    public String getT_title() {
        return t_title;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public String getT_classify() {
        return t_classify;
    }

    public void setT_classify(String t_classify) {
        this.t_classify = t_classify;
    }

    public int getT_status() {
        return t_status;
    }

    public void setT_status(int t_status) {
        this.t_status = t_status;
    }

    public int getT_isdelete() {
        return t_isdelete;
    }

    public void setT_isdelete(int t_isdelete) {
        this.t_isdelete = t_isdelete;
    }

    public String getT_createTime() {
        return t_createTime;
    }

    public void setT_createTime(String t_createTime) {
        this.t_createTime = t_createTime;
    }

    public String getT_checkNum() {
        return t_checkNum;
    }

    public void setT_checkNum(String t_checkNum) {
        this.t_checkNum = t_checkNum;
    }

    public String getT_url() {
        return t_url;
    }

    public void setT_url(String t_url) {
        this.t_url = t_url;
    }

    public String getT_startTime() {
        return t_startTime;
    }

    public void setT_startTime(String t_startTime) {
        this.t_startTime = t_startTime;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getT_statusStr() {
        if (t_status==0){
            t_statusStr="未开启";
        }else if (t_status==1){
            t_statusStr="已开启";
        }
        return t_statusStr;
    }

    public void setT_statusStr(String t_statusStr) {
        this.t_statusStr = t_statusStr;
    }

    @Override
    public String toString() {
        return "TestPaper{" +
                "t_id='" + t_id + '\'' +
                ", t_title='" + t_title + '\'' +
                ", t_classify='" + t_classify + '\'' +
                ", t_status=" + t_status +
                ", t_isdelete=" + t_isdelete +
                ", t_createTime='" + t_createTime + '\'' +
                ", t_checkNum='" + t_checkNum + '\'' +
                ", t_url='" + t_url + '\'' +
                ", t_startTime='" + t_startTime + '\'' +
                ", u_id='" + u_id + '\'' +
                ", t_statusStr='" + t_statusStr + '\'' +
                ", t_endTime='" + t_endTime + '\'' +
                '}';
    }
}
