package com.group3.group3.repository;

import com.group3.group3.entity.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TuitionRepository extends JpaRepository<Tuition,Integer> {
    Tuition findBySchoolYearAndMajor(String schoolYear,String major);
}
