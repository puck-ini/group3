package com.group3.group3.repository;

import com.group3.group3.entity.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination,Integer> {
    List<Examination> findAllByUid(Integer uid);
    Examination findByUidAndCrid(Integer uid,Integer crid);
}
