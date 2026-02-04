package com.demo.dto;



import java.time.LocalDate;

public class CourseRequest {

    private String cname;
    private int duration;
    private LocalDate startDate;
    private Long trainerId;

    public CourseRequest() {}

    public CourseRequest(String cname, int duration, LocalDate startDate, Long trainerId) {
        this.cname = cname;
        this.duration = duration;
        this.startDate = startDate;
        this.trainerId = trainerId;
    }

    // Getters and Setters
    public String getCname() { return cname; }
    public void setCname(String cname) { this.cname = cname; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public Long getTrainerId() { return trainerId; }
    public void setTrainerId(Long trainerId) { this.trainerId = trainerId; }
}

