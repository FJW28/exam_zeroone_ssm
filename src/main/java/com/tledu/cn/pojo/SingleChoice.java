package com.tledu.cn.pojo;
/*
* 单选题实体类
* */
public class SingleChoice {
    private String s_id;  //单选题id
    private String s_type;   //题目类型
    private String s_content;   //题目内容
    private String s_a;     //abcd四个选项
    private String s_b;
    private String s_c;
    private String s_d;
    private int    s_score;  //题目分数
    private String s_answer;    //题目答案
    private String s_classify;  //单选题分类
    private String u_id;    //用户（出题人）id
    private int    s_delete;  //是否删除，0否1是
    private String s_createTime;    //创建时间

    public SingleChoice(String s_id, String s_type, String s_content, String s_a, String s_b, String s_c, String s_d, int s_score, String s_answer, String s_classify, String u_id, int s_delete, String s_createTime) {
        this.s_id = s_id;
        this.s_type = s_type;
        this.s_content = s_content;
        this.s_a = s_a;
        this.s_b = s_b;
        this.s_c = s_c;
        this.s_d = s_d;
        this.s_score = s_score;
        this.s_answer = s_answer;
        this.s_classify = s_classify;
        this.u_id = u_id;
        this.s_delete = s_delete;
        this.s_createTime = s_createTime;
    }

    public SingleChoice() {
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    public String getS_content() {
        return s_content;
    }

    public void setS_content(String s_content) {
        this.s_content = s_content;
    }

    public String getS_a() {
        return s_a;
    }

    public void setS_a(String s_a) {
        this.s_a = s_a;
    }

    public String getS_b() {
        return s_b;
    }

    public void setS_b(String s_b) {
        this.s_b = s_b;
    }

    public String getS_c() {
        return s_c;
    }

    public void setS_c(String s_c) {
        this.s_c = s_c;
    }

    public String getS_d() {
        return s_d;
    }

    public void setS_d(String s_d) {
        this.s_d = s_d;
    }

    public int getS_score() {
        return s_score;
    }

    public void setS_score(int s_score) {
        this.s_score = s_score;
    }

    public String getS_answer() {
        return s_answer;
    }

    public void setS_answer(String s_answer) {
        this.s_answer = s_answer;
    }

    public String getS_classify() {
        return s_classify;
    }

    public void setS_classify(String s_classify) {
        this.s_classify = s_classify;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public int getS_delete() {
        return s_delete;
    }

    public void setS_delete(int s_delete) {
        this.s_delete = s_delete;
    }

    public String getS_createTime() {
        return s_createTime;
    }

    public void setS_createTime(String s_createTime) {
        this.s_createTime = s_createTime;
    }

    @Override
    public String toString() {
        return "SingleChoice{" +
                "s_id='" + s_id + '\'' +
                ", s_type='" + s_type + '\'' +
                ", s_content='" + s_content + '\'' +
                ", s_a='" + s_a + '\'' +
                ", s_b='" + s_b + '\'' +
                ", s_c='" + s_c + '\'' +
                ", s_d='" + s_d + '\'' +
                ", s_score=" + s_score +
                ", s_answer='" + s_answer + '\'' +
                ", s_classify='" + s_classify + '\'' +
                ", u_id='" + u_id + '\'' +
                ", s_delete=" + s_delete +
                ", s_createTime='" + s_createTime + '\'' +
                '}';
    }
}
