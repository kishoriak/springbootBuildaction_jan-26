package com.demo.controller;



import com.demo.beans.Course;
import com.demo.beans.Trainer;
import com.demo.dao.CourseRepository;
import com.demo.dao.TrainerRepository;
import com.demo.dto.CourseRequest;
import com.demo.dto.CourseDTO;


import com.demo.service.CourseService;
import com.demo.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final TrainerService trainerService;

    public CourseController(CourseService courseService, TrainerService trainerService) {
        this.courseService = courseService;
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAll()
                .stream()
                .map(c -> new CourseDTO(c.getCid(), c.getCname(), c.getDuration(), c.getStartDate()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Course addCourse(@RequestBody CourseRequest request) {
        Trainer trainer = trainerService.getById(request.getTrainerId())
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        Course course = new Course();
        course.setCname(request.cname());
        course.setDuration(request.duration());
        course.setStartDate(request.startDate());
        course.setTrainer(trainer);
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody CourseRequest request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Trainer trainer = trainerRepository.findById(request.trainerId())
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        course.setCname(request.cname());
        course.setDuration(request.duration());
        course.setStartDate(request.startDate());
        course.setTrainer(trainer);
        return courseRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }
}


    // 🔹 PUT
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable int id,
            @RequestBody Course course) {

        return ResponseEntity.ok(courseService.updateCourse(id, course));
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }



}
