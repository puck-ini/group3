package com.group3.group3.entity;

import javax.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;

    private String cname;

    private Integer uid;

    private String username;

    private Double grade;

    private Integer attendance;

    private Integer absence;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Integer getAbsence() {
        return absence;
    }

    public void setAbsence(Integer absence) {
        this.absence = absence;
    }

    @Override
    public String toString(){
        return "Grade{" +
                "gid=" + gid +
                ", cname='" + cname + '\'' +
                ", uid='" + uid + '\'' +
                ", grade='" + grade + '\'' +
                ", attendance='" + attendance + '\'' +
                ", absence='" + absence + '\''+
                '}';
    }
}
