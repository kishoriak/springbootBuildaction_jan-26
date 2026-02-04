package com.demo.beans;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    private String cname;
    private int duration; // in hours

    private LocalDate startDate; // changed from String to LocalDate

    @ManyToOne
    @JoinColumn(name="trainer_id")
    private Trainer trainer;
}


