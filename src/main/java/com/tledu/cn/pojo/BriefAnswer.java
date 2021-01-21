package com.tledu.cn.pojo;

public class BriefAnswer {
    /*
    * 简答题实体类
    * */
    private String b_id;    //简答题id
    private String b_type;  //题目类型
    private String b_content;   //题目内容
    private int    b_score;     //题目分数
    private String b_answer;    //题目答案
    private String b_classify;  //简答题分类
    private String u_id;    //用户（出题人）id
    private int    b_isdelete;  //是否删除，0否，1是
    private String b_createTime;    //创建时间

    public BriefAnswer(String b_id, String b_type, String b_content, int b_score, String b_answer, String b_classify, String u_id, int b_isdelete, String b_createTime) {
        this.b_id = b_id;
        this.b_type = b_type;
        this.b_content = b_content;
        this.b_score = b_score;
        this.b_answer = b_answer;
        this.b_classify = b_classify;
        this.u_id = u_id;
        this.b_isdelete = b_isdelete;
        this.b_createTime = b_createTime;
    }

    public BriefAnswer() {
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public String getB_type() {
        return b_type;
    }

    public void setB_type(String b_type) {
        this.b_type = b_type;
    }

    public String getB_content() {
        return b_content;
    }

    public void setB_content(String b_content) {
        this.b_content = b_content;
    }

    public int getB_score() {
        return b_score;
    }

    public void setB_score(int b_score) {
        this.b_score = b_score;
    }

    public String getB_answer() {
        return b_answer;
    }

    public void setB_answer(String b_answer) {
        this.b_answer = b_answer;
    }

    public String getB_classify() {
        return b_classify;
    }

    public void setB_classify(String b_classify) {
        this.b_classify = b_classify;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public int getB_isdelete() {
        return b_isdelete;
    }

    public void setB_isdelete(int b_isdelete) {
        this.b_isdelete = b_isdelete;
    }

    public String getB_createTime() {
        return b_createTime;
    }

    public void setB_createTime(String b_createTime) {
        this.b_createTime = b_createTime;
    }

    @Override
    public String toString() {
        return "BriefAnswer{" +
                "b_id='" + b_id + '\'' +
                ", b_type='" + b_type + '\'' +
                ", b_content='" + b_content + '\'' +
                ", b_score=" + b_score +
                ", b_answer='" + b_answer + '\'' +
                ", b_classify='" + b_classify + '\'' +
                ", u_id='" + u_id + '\'' +
                ", b_isdelete=" + b_isdelete +
                ", b_createTime='" + b_createTime + '\'' +
                '}';
    }
}
