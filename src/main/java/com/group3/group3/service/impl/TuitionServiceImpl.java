package com.group3.group3.service.impl;

import com.group3.group3.entity.StudentTuition;
import com.group3.group3.entity.Tuition;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.StudentTuitionRepository;
import com.group3.group3.repository.TuitionRepository;
import com.group3.group3.service.TuitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuitionServiceImpl implements TuitionService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TuitionRepository tuitionRepository;

    @Override
    public Tuition getTuition(String schoolYear,String major) {
        return tuitionRepository.findBySchoolYearAndMajor(schoolYear, major);
    }

    @Override
    public Tuition insertTuition(Tuition tuition) {
        verifyTuiton(tuition.getSchoolYear(),tuition.getMajor());
        tuitionRepository.save(tuition);
        return tuition;
    }

    @Override
    public void deleteTuiTion(Integer tuid) {
        tuitionRepository.deleteById(tuid);
    }

    @Override
    public Tuition updateTuition(Tuition tuition) {
        return tuitionRepository.save(tuition);
    }

    @Override
    public List<Tuition> getAll() {
        return tuitionRepository.findAll();
    }

    private void verifyTuiton(String schoolYear,String major){
        Tuition tuition = tuitionRepository.findBySchoolYearAndMajor(schoolYear,major);
        if (tuition != null){
            throw new HandleException(ExceptionEnum.EXIST_TUITION);
        }
    }
}
