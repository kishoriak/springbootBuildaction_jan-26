package com.demo;

import com.demo.beans.Trainer;
import com.demo.dao.CourseRepository;
import com.demo.dao.TrainerRepository;
import com.demo.exception.TrainerNotFoundException;
import com.demo.service.TrainerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpringBootTrainerTest {


        @Mock
        private TrainerRepository trainerRepository;

        @Mock
        private CourseRepository courseRepo;

        @InjectMocks
        private TrainerServiceImpl trainerService;


    private Trainer getTrainer() {
        Trainer t = new Trainer();
        t.setTid(1);
        t.setTname("Ravi");
        t.setExperience(10);
        return t;
    }

    @Test
    void saveTrainer_success() {

        Trainer trainer = getTrainer();

        when(trainerRepository.save(trainer)).thenReturn(trainer);

        Trainer saved = trainerService.saveTrainer(trainer);

        assertNotNull(saved);
        assertEquals("Ravi", saved.getTname());
        verify(trainerRepository, times(1)).save(trainer);
    }

    @Test
    void getTrainerById_success() {

        Trainer trainer = getTrainer();

        when(trainerRepository.findTrainerWithCourses(1)).thenReturn(trainer);

        Trainer result = trainerService.getById(1);

        assertEquals(1, result.getTid());
        assertEquals("Ravi", result.getTname());
    }
    @Test
    void getTrainerById_notFound() {

        when(trainerRepository.findTrainerWithCourses(100)).thenReturn(null);

        TrainerNotFoundException ex =
                assertThrows(TrainerNotFoundException.class,
                        () -> trainerService.getById(100));
        System.out.println(ex.getMessage());
        assertEquals("Trainer not Found 100", ex.getMessage());
    }


}
