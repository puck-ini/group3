package com.group3.group3.repository;

import com.group3.group3.entity.Research;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResearchRepository extends JpaRepository<Research,Integer> {

    List<Research> findAllByUid(Integer uid);

    List<Research> findAllByUsername(String username);

    List<Research> findAllByResearchNameLike(String researchName);

    Research findByUidAndResearchName(Integer uid,String researchName);
}
