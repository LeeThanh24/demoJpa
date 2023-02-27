package com.thanhLee.demoJPA.entity;

import javax.persistence.Column;
import java.io.Serializable;


public class IdJobUser implements Serializable {
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "job_id")
    private int job_id;
    public IdJobUser() {

    }

    public IdJobUser(int userId, int jobId) {
        this.user_id = userId;
        this.job_id = jobId;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public int getJobId() {
        return job_id;
    }

    public void setJobId(int jobId) {
        this.job_id = jobId;
    }
}
