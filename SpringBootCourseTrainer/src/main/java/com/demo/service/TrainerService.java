package com.demo.service;

import com.demo.beans.Course;
import com.demo.beans.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> getAll();

    Trainer getById(int id);

    Trainer saveTrainer(Trainer trainer);

    Course addCourseToTrainer(int trainerId, Course course);

    Trainer updateTrainer(int id, Trainer trainer);

    void deleteTrainer(int id);
}
