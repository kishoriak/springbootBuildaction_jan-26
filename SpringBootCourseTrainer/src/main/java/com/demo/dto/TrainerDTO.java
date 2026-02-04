package com.demo.dto;



import java.util.List;

public class TrainerDTO {

    private Long tid;
    private String tname;
    private int experience;
    private List<CourseDTO> courses;

    public TrainerDTO() {}

    public TrainerDTO(Long tid, String tname, int experience, List<CourseDTO> courses) {
        this.tid = tid;
        this.tname = tname;
        this.experience = experience;
        this.courses = courses;
    }

    // Getters and Setters
    public Long getTid() { return tid; }
    public void setTid(Long tid) { this.tid = tid; }

    public String getTname() { return tname; }
    public void setTname(String tname) { this.tname = tname; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    public List<CourseDTO> getCourses() { return courses; }
    public void setCourses(List<CourseDTO> courses) { this.courses = courses; }
}

