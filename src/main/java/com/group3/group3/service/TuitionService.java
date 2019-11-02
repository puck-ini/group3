package com.group3.group3.service;

import com.group3.group3.entity.Tuition;

import java.util.List;

public interface TuitionService {

    Tuition getTuition(String schoolYear,String major);

    Tuition insertTuition(Tuition tuition);

    void deleteTuiTion(Integer tuid);

    Tuition updateTuition(Tuition tuition);

    List<Tuition> getAll();

}
