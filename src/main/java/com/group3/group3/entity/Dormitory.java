package com.group3.group3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dormitory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dmid;

    private String dmname;

    private Double light;

    private Double water;

    private Double internet;

    public Integer getDmid() {
        return dmid;
    }

    public void setDmid(Integer dmid) {
        this.dmid = dmid;
    }

    public String getDmname() {
        return dmname;
    }

    public void setDmname(String dmname) {
        this.dmname = dmname;
    }

    public Double getLight() {
        return light;
    }

    public void setLight(Double light) {
        this.light = light;
    }

    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    public Double getInternet() {
        return internet;
    }

    public void setInternet(Double internet) {
        this.internet = internet;
    }
}
