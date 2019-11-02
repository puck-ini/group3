package com.group3.group3.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentTuition {

    @Id
    private Integer uid;

    private Integer tuid;

    private Boolean handMoney;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTuid() {
        return tuid;
    }

    public void setTuid(Integer tuid) {
        this.tuid = tuid;
    }

    public Boolean getHandMoney() {
        return handMoney;
    }

    public void setHandMoney(Boolean handMoney) {
        this.handMoney = handMoney;
    }
}
