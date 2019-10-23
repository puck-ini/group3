package com.group3.group3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    private Integer uid;

    private String cname;

    private String csyear;

    private String semester;

    private String ctype;

    private String classdate;

    private String classplace;

    private Integer exid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsyear() {
        return csyear;
    }

    public void setCsyear(String csyear) {
        this.csyear = csyear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getClassdate() {
        return classdate;
    }

    public void setClassdate(String classdate) {
        this.classdate = classdate;
    }

    public String getClassplace() {
        return classplace;
    }

    public void setClassplace(String classplace) {
        this.classplace = classplace;
    }

    public Integer getExid() {
        return exid;
    }

    public void setExid(Integer exid) {
        this.exid = exid;
    }


    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", cname='" + cname + '\'' +
                ", csyear='" + csyear + '\'' +
                ", semester='" + semester + '\'' +
                ", ctype='" + ctype + '\'' +
                ", classdate='" + classdate + '\'' +
                ", classplace='" + classplace + '\'' +
                ", exid=" + exid +
                '}';
    }
}
