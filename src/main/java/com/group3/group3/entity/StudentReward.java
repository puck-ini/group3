package com.group3.group3.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentReward {
    @Id
    private Integer uid;

    private Integer reid;

    private String reason;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
