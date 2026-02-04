package com.demo.service;

import com.demo.beans.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();

    Course addCourse(Course course);

    Course updateCourse(Long id, Course course);

    void deleteCourse(int id);
}
