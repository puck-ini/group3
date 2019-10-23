package com.group3.group3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Research {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer researchid;

    private Integer uid;

    private String researchName;

    private String researchInformation;

    public Integer getResearchid() {
        return researchid;
    }

    public void setResearchid(Integer researchid) {
        this.researchid = researchid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public String getResearchInformation() {
        return researchInformation;
    }

    public void setResearchInformation(String researchInformation) {
        this.researchInformation = researchInformation;
    }
}
