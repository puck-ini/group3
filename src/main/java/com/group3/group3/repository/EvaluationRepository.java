package com.group3.group3.repository;

import com.group3.group3.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {

    List<Evaluation> findAllByUid(Integer uid);

}
