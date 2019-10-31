package com.group3.group3.service.impl;

import com.group3.group3.entity.Evaluation;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.EvaluationRepository;
import com.group3.group3.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public Evaluation insertEvInfo(Evaluation evaluation) {
        verifyUid(evaluation.getUid());
        evaluationRepository.save(evaluation);
        return evaluation;
    }

    private void verifyUid(Integer uid){
        List<Evaluation> employmentList = evaluationRepository.findAllByUid(uid);
        if (employmentList.size() != 0){
            throw  new HandleException(ExceptionEnum.EXIST_USER);
        }
    }

    @Override
    public Evaluation deleteEvInfo(Integer evid) {
        evaluationRepository.deleteById(evid);
        return null;
    }

    @Override
    public List<Evaluation> getAllEvInfo() {
        return evaluationRepository.findAll();
    }

    @Override
    public List<Evaluation> getOneEvInfo(Integer uid) {
        return evaluationRepository.findAllByUid(uid);
    }
}
