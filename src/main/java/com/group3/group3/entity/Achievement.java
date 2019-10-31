package com.group3.group3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aeid;

    private Integer uid;

    private String username;

    private String aeInformation;

    public Integer getAeid() {
        return aeid;
    }

    public void setAeid(Integer aeid) {
        this.aeid = aeid;
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

    public String getAeInformation() {
        return aeInformation;
    }

    public void setAeInformation(String aeInformation) {
        this.aeInformation = aeInformation;
    }
}
