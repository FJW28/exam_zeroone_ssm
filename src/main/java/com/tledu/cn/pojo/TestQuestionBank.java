package com.tledu.cn.pojo;

public class TestQuestionBank {
    private String tq_id;   //主键id
    private String tq_type; //题目类型
    private String tq_content;  //单选题题目
    private String tq_a;    //a-d四个选项
    private String tq_b;
    private String tq_c;
    private String tq_d;
    private int    tq_score;    //题目分数
    private String tq_answer;   //题目答案
    private String tq_classify;     //题目分类
    private String u_id;    //关联用户id
    private int    tq_isdelete;     //0未删除，1已删除
    private String tq_createTime;   //创建时间
    private String t_id;    //试卷id

    public TestQuestionBank(String tq_id, String tq_type, String tq_content, String tq_a, String tq_b, String tq_c, String tq_d, int tq_score, String tq_answer, String tq_classify, String u_id, int tq_isdelete, String tq_createTime, String t_id) {
        this.tq_id = tq_id;
        this.tq_type = tq_type;
        this.tq_content = tq_content;
        this.tq_a = tq_a;
        this.tq_b = tq_b;
        this.tq_c = tq_c;
        this.tq_d = tq_d;
        this.tq_score = tq_score;
        this.tq_answer = tq_answer;
        this.tq_classify = tq_classify;
        this.u_id = u_id;
        this.tq_isdelete = tq_isdelete;
        this.tq_createTime = tq_createTime;
        this.t_id = t_id;
    }

    public TestQuestionBank() {
    }

    public String getTq_id() {
        return tq_id;
    }

    public void setTq_id(String tq_id) {
        this.tq_id = tq_id;
    }

    public String getTq_type() {
        return tq_type;
    }

    public void setTq_type(String tq_type) {
        this.tq_type = tq_type;
    }

    public String getTq_content() {
        return tq_content;
    }

    public void setTq_content(String tq_content) {
        this.tq_content = tq_content;
    }

    public String getTq_a() {
        return tq_a;
    }

    public void setTq_a(String tq_a) {
        this.tq_a = tq_a;
    }

    public String getTq_b() {
        return tq_b;
    }

    public void setTq_b(String tq_b) {
        this.tq_b = tq_b;
    }

    public String getTq_c() {
        return tq_c;
    }

    public void setTq_c(String tq_c) {
        this.tq_c = tq_c;
    }

    public String getTq_d() {
        return tq_d;
    }

    public void setTq_d(String tq_d) {
        this.tq_d = tq_d;
    }

    public int getTq_score() {
        return tq_score;
    }

    public void setTq_score(int tq_score) {
        this.tq_score = tq_score;
    }

    public String getTq_answer() {
        return tq_answer;
    }

    public void setTq_answer(String tq_answer) {
        this.tq_answer = tq_answer;
    }

    public String getTq_classify() {
        return tq_classify;
    }

    public void setTq_classify(String tq_classify) {
        this.tq_classify = tq_classify;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public int getTq_isdelete() {
        return tq_isdelete;
    }

    public void setTq_isdelete(int tq_isdelete) {
        this.tq_isdelete = tq_isdelete;
    }

    public String getTq_createTime() {
        return tq_createTime;
    }

    public void setTq_createTime(String tq_createTime) {
        this.tq_createTime = tq_createTime;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    @Override
    public String toString() {
        return "TestQuestionBank{" +
                "tq_id='" + tq_id + '\'' +
                ", tq_type='" + tq_type + '\'' +
                ", tq_content='" + tq_content + '\'' +
                ", tq_a='" + tq_a + '\'' +
                ", tq_b='" + tq_b + '\'' +
                ", tq_c='" + tq_c + '\'' +
                ", tq_d='" + tq_d + '\'' +
                ", tq_score=" + tq_score +
                ", tq_answer='" + tq_answer + '\'' +
                ", tq_classify='" + tq_classify + '\'' +
                ", u_id='" + u_id + '\'' +
                ", tq_isdelete=" + tq_isdelete +
                ", tq_createTime='" + tq_createTime + '\'' +
                ", t_id='" + t_id + '\'' +
                '}';
    }
}
