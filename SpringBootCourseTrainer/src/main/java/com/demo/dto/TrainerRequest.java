package com.demo.dto;



public class TrainerRequest {

    private String tname;
    private int experience;

    public TrainerRequest() {}

    public TrainerRequest(String tname, int experience) {
        this.tname = tname;
        this.experience = experience;
    }

    // Getters and Setters
    public String getTname() { return tname; }
    public void setTname(String tname) { this.tname = tname; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
}

