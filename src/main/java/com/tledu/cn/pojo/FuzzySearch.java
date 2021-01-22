package com.tledu.cn.pojo;

public class FuzzySearch {

    private String u_id;
    private String q_content;


    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getQ_content() {
        return q_content;
    }

    public void setQ_content(String q_content) {
        this.q_content = q_content;
    }

    @Override
    public String toString() {
        return "FuzzySearch{" +
                "u_id='" + u_id + '\'' +
                ", q_content='" + q_content + '\'' +
                '}';
    }
}
