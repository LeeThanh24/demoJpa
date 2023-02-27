package com.thanhLee.demoJPA.entity;

import javax.persistence.*;

@Entity(name = "sub_job")
@IdClass(IdJobUser.class)
public class SubJobEntity {
    @Id
    private int user_id;
    @Id
    private int job_id;
    private String subJobName;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getSubJobName() {
        return subJobName;
    }

    public void setSubJobName(String subJobName) {
        this.subJobName = subJobName;
    }
}
