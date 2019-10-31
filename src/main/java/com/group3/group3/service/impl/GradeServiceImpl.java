package com.group3.group3.service.impl;

import com.group3.group3.entity.Grade;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.GradeRepository;
import com.group3.group3.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public Grade insertOne(Grade grade) {
        verifyGrade(grade.getUsername(),grade.getCname());
        gradeRepository.save(grade);
        return grade;
    }

    private void verifyGrade(String username,String cname){
        List<Grade> gradeList = gradeRepository.findByUsernameAndCname(username, cname);
        if (gradeList.size() != 0){
            throw new HandleException(ExceptionEnum.EXIST_GRADE);
        }
    }

    @Override
    public Grade updateOne(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade delete(Integer gid) {
        gradeRepository.deleteById(gid);
        return null;
    }

    @Override
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    @Override
    public List<Grade> getPersonInfo(String username) {
        return gradeRepository.findAllByUsername(username);
    }

    @Override
    public List<Grade> getOneGradeInfo(String cname) {
        return gradeRepository.findAllByCname(cname);
    }

    @Override
    public Grade getOne(Integer uid, String cname) {
        return gradeRepository.findByUidAndCname(uid,cname);
    }


}
