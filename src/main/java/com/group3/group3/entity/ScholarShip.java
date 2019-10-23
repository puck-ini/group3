package com.group3.group3.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScholarShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ssid;

    private String name;

    private String type;

    private Double ssMoney;

    public Integer getSsid() {
        return ssid;
    }

    public void setSsid(Integer ssid) {
        this.ssid = ssid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSsMoney() {
        return ssMoney;
    }

    public void setSsMoney(Double ssMoney) {
        this.ssMoney = ssMoney;
    }
}
