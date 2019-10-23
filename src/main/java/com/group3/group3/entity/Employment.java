package com.group3.group3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    private Boolean ifgetjob;

    private String jobcity;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Boolean getIfgetjob() {
        return ifgetjob;
    }

    public void setIfgetjob(Boolean ifgetjob) {
        this.ifgetjob = ifgetjob;
    }

    public String getJobcity() {
        return jobcity;
    }

    public void setJobcity(String jobcity) {
        this.jobcity = jobcity;
    }
}
