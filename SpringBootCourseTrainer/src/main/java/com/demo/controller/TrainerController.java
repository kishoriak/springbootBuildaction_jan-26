package com.demo.controller;

import com.demo.beans.Course;
import com.demo.beans.Trainer;
import com.demo.service.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    //constructor Injection
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/trainers")
    public ResponseEntity<List<Trainer>> getAllTrainer(){
        List<Trainer> tlist=trainerService.getAll();
        return ResponseEntity.ok(tlist);
    }


    //retrieve the trainer with all courses the trainer conducts
    @GetMapping("/trainers/{id}")
    public Trainer getTrainerWithCourses(@PathVariable int id) {
        return trainerService.getById(id);
    }

    @PostMapping("/trainers")
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return trainerService.saveTrainer(trainer);
    }

    @PostMapping("/trainers/{trainerId}/courses")
    public Course addCourse(
            @PathVariable int trainerId,
            @RequestBody Course course) {

        return trainerService.addCourseToTrainer(trainerId, course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainer> updateTrainer(
            @PathVariable int id,
            @RequestBody Trainer trainer) {

        Trainer updatedTrainer = trainerService.updateTrainer(id, trainer);
        return ResponseEntity.ok(updatedTrainer);
    }

    @DeleteMapping("/trainers/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable int id) {
        trainerService.deleteTrainer(id);
        return ResponseEntity.ok("Trainer deleted, courses retained");
    }









}
