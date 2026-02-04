package com.demo.dto;



import java.time.LocalDate;

public class CourseDTO {

    private Long cid;
    private String cname;
    private int duration;
    private LocalDate startDate;

    public CourseDTO() {}

    public CourseDTO(Long cid, String cname, int duration, LocalDate startDate) {
        this.cid = cid;
        this.cname = cname;
        this.duration = duration;
        this.startDate = startDate;
    }

    // Getters and Setters
    public Long getCid() { return cid; }
    public void setCid(Long cid) { this.cid = cid; }

    public String getCname() { return cname; }
    public void setCname(String cname) { this.cname = cname; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
}
