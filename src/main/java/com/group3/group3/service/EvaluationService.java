package com.group3.group3.service;

import com.group3.group3.entity.Evaluation;

import java.util.List;

public interface EvaluationService {

    Evaluation insertEvInfo(Evaluation evaluation);

    Evaluation deleteEvInfo(Integer evid);

    List<Evaluation> getAllEvInfo();

    List<Evaluation> getOneEvInfo(Integer uid);

}
