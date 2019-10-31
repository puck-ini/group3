package com.group3.group3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exid;

    private Integer uid;

    private Integer crid;

    private Date exdate;

    public Integer getExid() {
        return exid;
    }

    public void setExid(Integer exid) {
        this.exid = exid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCrid() {
        return crid;
    }

    public void setCrid(Integer crid) {
        this.crid = crid;
    }

    public Date getExdate() {
        return exdate;
    }

    public void setExdate(Date exdate) {
        this.exdate = exdate;
    }

    @Override
    public String toString(){
        return "Examnation{" +
                "exid='" + exid + '\'' +
                ", uid='" + uid + '\'' +
                ", crid='" + crid + '\'' +
                ", exdate='" + exdate + '\'' +
                '}';
    }
}
