package com.demo.service;

import com.demo.beans.Course;
import com.demo.beans.Trainer;
import com.demo.dao.CourseRepository;
import com.demo.dao.TrainerRepository;
import com.demo.exception.TrainerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService{
    @Autowired
    private CourseRepository courseRepository;

    TrainerRepository trainerRepository;

    //Constructor injection
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public List<Trainer> getAll() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getById(int id) {

        return   trainerRepository.findById(id).orElseThrow(() -> new TrainerNotFoundException("Trainer not Found "+id));


    }

    @Override
    public Trainer saveTrainer(Trainer trainer) {
                return trainerRepository.save(trainer);
    }

    @Override
    public Course addCourseToTrainer(int trainerId, Course course) {

            Trainer trainer = trainerRepository.findById(trainerId)
                    .orElseThrow(() -> new TrainerNotFoundException(trainerId));

            course.setTrainer(trainer);   // mapping happens here

            return courseRepository.save(course);

    }

    public Trainer updateTrainer(int id, Trainer trainer) {

        Trainer existingTrainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id " + id));

        existingTrainer.setTname(trainer.getTname());
        existingTrainer.setExperience(trainer.getExperience());

        return trainerRepository.save(existingTrainer);
    }



    @Transactional
    public void deleteTrainer(int id) {

        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Trainer not found"
                ));

        // Set trainer = null for all courses
        List<Course> courses = courseRepository.findByTrainer(trainer);
        for (Course c : courses) {
            c.setTrainer(null);
        }

        trainerRepository.delete(trainer);
    }
}
