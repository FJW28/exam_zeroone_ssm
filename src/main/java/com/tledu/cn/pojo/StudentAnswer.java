package com.tledu.cn.pojo;

public class StudentAnswer {
    private String sa_id;   //主键id
    private String sa_type;     //试题类型
    private String sa_answer;   //考生答案
    private String q_id;    //试题id
    private String t_id;    //试卷id
    private String stu_id;  //考生id
    private int sa_score;   //单题分数

    public StudentAnswer(String sa_id, String sa_type, String sa_answer, String q_id, String t_id, String stu_id, int sa_score) {
        this.sa_id = sa_id;
        this.sa_type = sa_type;
        this.sa_answer = sa_answer;
        this.q_id = q_id;
        this.t_id = t_id;
        this.stu_id = stu_id;
        this.sa_score = sa_score;
    }

    public StudentAnswer() {
    }

    public String getSa_id() {
        return sa_id;
    }

    public void setSa_id(String sa_id) {
        this.sa_id = sa_id;
    }

    public String getSa_type() {
        return sa_type;
    }

    public void setSa_type(String sa_type) {
        this.sa_type = sa_type;
    }

    public String getSa_answer() {
        return sa_answer;
    }

    public void setSa_answer(String sa_answer) {
        this.sa_answer = sa_answer;
    }

    public String getQ_id() {
        return q_id;
    }

    public void setQ_id(String q_id) {
        this.q_id = q_id;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public int getSa_score() {
        return sa_score;
    }

    public void setSa_score(int sa_score) {
        this.sa_score = sa_score;
    }

    @Override
    public String toString() {
        return "StudentAnswer{" +
                "sa_id='" + sa_id + '\'' +
                ", sa_type='" + sa_type + '\'' +
                ", sa_answer='" + sa_answer + '\'' +
                ", q_id='" + q_id + '\'' +
                ", t_id='" + t_id + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", sa_score=" + sa_score +
                '}';
    }
}
