package com.demo.dao;

import com.demo.beans.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {

    //@Query("SELECT t FROM Trainer t LEFT JOIN FETCH t.courses WHERE t.tid = :id")
    //Trainer findTrainerWithCourses(@Param("id") int id);

}
