package com.demo.dao;

import com.demo.beans.Course;
import com.demo.beans.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByTrainer(Trainer trainer);
}
