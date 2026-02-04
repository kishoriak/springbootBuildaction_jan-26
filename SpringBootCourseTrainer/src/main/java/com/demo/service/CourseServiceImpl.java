package com.demo.service;



import com.demo.beans.Course;
import com.demo.dao.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    CourseRepository courseRepository;


    // Constructor Injection (Best Practice)
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    // ✅ PUT – Update course
    public Course updateCourse(int id, Course course) {

        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Course not found"
                ));

        existing.setCname(course.getCname());
        existing.setDuration(course.getDuration());
        existing.setTrainer(course.getTrainer());

        return courseRepository.save(existing);
    }

    // ✅ DELETE – Delete course
    public void deleteCourse(int id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Course not found"
                ));

        courseRepository.delete(course);
    }
}
