package com.group3.group3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emid;

    private Integer uid;

    private String username;

    private Boolean ifgetjob;

    private String jobcity;


    public Integer getEmid() {
        return emid;
    }

    public void setEmid(Integer emid) {
        this.emid = emid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString(){
        return "Department{"+
                "emid=" + emid +
                ", uid='" + uid + '\'' +
                ", ifgetjob='" + ifgetjob + '\'' +
                ", jobcity='" + jobcity + '\'' +
                '}';
    }
}
