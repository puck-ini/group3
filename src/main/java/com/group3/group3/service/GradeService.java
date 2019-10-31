package com.group3.group3.service;

import com.group3.group3.entity.Grade;

import java.util.List;

public interface GradeService {

    Grade insertOne(Grade grade);

    Grade updateOne(Grade grade);

    Grade delete(Integer gid);

    List<Grade> getAll();

    List<Grade> getPersonInfo(String username);

    List<Grade> getOneGradeInfo(String cname);

    Grade getOne(Integer uid,String cname);

}
