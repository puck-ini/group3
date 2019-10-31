package com.group3.group3.service;

import com.group3.group3.entity.Research;

import java.util.List;

public interface ResearchService {

    Research insertOne(Research research);

    Research updateOne(Research research);

    Research deleteOne(Integer researchid);

    List<Research> getAllReInfo();

    List<Research> getPersonInfo(String username);

    List<Research> getOneReAllInfo(String researchName);

    Research getOne(Integer uid,String researchName);
}
