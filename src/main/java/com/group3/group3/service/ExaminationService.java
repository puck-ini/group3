package com.group3.group3.service;

import com.group3.group3.entity.Examination;

import java.text.ParseException;
import java.util.List;

public interface ExaminationService {

    Examination insertExInfo(Examination examination) throws ParseException;

    Examination deleteExInfo(Integer exid);

    Examination updateExInfo(Examination examination);

    List<Examination> getAllExInfo();

    List<Examination> getOneExInfo(Integer uid);

    Examination getOne(Integer uid,Integer crid);
}
