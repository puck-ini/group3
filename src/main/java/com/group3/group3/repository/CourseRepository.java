package com.group3.group3.repository;

import com.group3.group3.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findByCnameLike(String name);


}
