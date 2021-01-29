package com.tledu.cn.pojo;

import java.io.Serializable;

/*
* 单选题实体类
* */
public class QuestionBank implements Serializable {
    private String q_id;  //单选题id
    private String q_type;   //题目类型
    private String q_content;   //题目内容
    private String q_a;     //abcd四个选项
    private String q_b;
    private String q_c;
    private String q_d;
    private int    q_score;  //题目分数
    private String q_answer;    //题目答案
    private String q_classify;  //单选题分类
    private String u_id;    //用户（出题人）id
    private int q_isadd;
    private int    q_isdelete;  //是否删除，0否1是
    private String q_createTime;    //创建时间

    public String getQ_id() {
        return q_id;
    }

    public void setQ_id(String q_id) {
        this.q_id = q_id;
    }

    public String getQ_type() {
        return q_type;
    }

    public void setQ_type(String q_type) {
        this.q_type = q_type;
    }

    public String getQ_content() {
        return q_content;
    }

    public void setQ_content(String q_content) {
        this.q_content = q_content;
    }

    public String getQ_a() {
        return q_a;
    }

    public void setQ_a(String q_a) {
        this.q_a = q_a;
    }

    public String getQ_b() {
        return q_b;
    }

    public void setQ_b(String q_b) {
        this.q_b = q_b;
    }

    public String getQ_c() {
        return q_c;
    }

    public void setQ_c(String q_c) {
        this.q_c = q_c;
    }

    public String getQ_d() {
        return q_d;
    }

    public void setQ_d(String q_d) {
        this.q_d = q_d;
    }

    public int getQ_score() {
        return q_score;
    }

    public void setQ_score(int q_score) {
        this.q_score = q_score;
    }

    public String getQ_answer() {
        return q_answer;
    }

    public void setQ_answer(String q_answer) {
        this.q_answer = q_answer;
    }

    public String getQ_classify() {
        return q_classify;
    }

    public void setQ_classify(String q_classify) {
        this.q_classify = q_classify;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public int getQ_isadd() {
        return q_isadd;
    }

    public void setQ_isadd(int q_isadd) {
        this.q_isadd = q_isadd;
    }

    public int getQ_isdelete() {
        return q_isdelete;
    }

    public void setQ_isdelete(int q_isdelete) {
        this.q_isdelete = q_isdelete;
    }

    public String getQ_createTime() {
        return q_createTime;
    }

    public void setQ_createTime(String q_createTime) {
        this.q_createTime = q_createTime;
    }

    @Override
    public String toString() {
        return "QuestionBank{" +
                "q_id='" + q_id + '\'' +
                ", q_type='" + q_type + '\'' +
                ", q_content='" + q_content + '\'' +
                ", q_a='" + q_a + '\'' +
                ", q_b='" + q_b + '\'' +
                ", q_c='" + q_c + '\'' +
                ", q_d='" + q_d + '\'' +
                ", q_score=" + q_score +
                ", q_answer='" + q_answer + '\'' +
                ", q_classify='" + q_classify + '\'' +
                ", u_id='" + u_id + '\'' +
                ", q_isadd=" + q_isadd +
                ", q_isdelete=" + q_isdelete +
                ", q_createTime='" + q_createTime + '\'' +
                '}';
    }
}
