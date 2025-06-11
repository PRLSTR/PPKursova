package com.touragency.model;

import java.time.LocalDateTime;

// Модель Guide
public class Guide {
    private int guideId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int experienceYears;
    private String specialization;

    public Guide() {}

    public Guide(int guideId, String firstName, String lastName, String phoneNumber, String email, int experienceYears, String specialization) {
        this.guideId = guideId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.experienceYears = experienceYears;
        this.specialization = specialization;
    }

    public int getGuideId() {
        return guideId;
    }
    public void setGuideId(int guideId) {
        this.guideId = guideId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
