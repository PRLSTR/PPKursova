package com.touragency.model;

import java.time.LocalDateTime;

//переліки
public class Tour {
    private int tourId;
    private String tourName;
    private double price;
    private LocalDateTime dateTime;
    private String duration; // або Duration, але простіше як String для початку
    private double rating;
    private String tourType;
    private String description;
    private String type;
    private String language;
    private int maxGroupSize;
    private String difficultyLevel;
    private String detailedDescription;
    private String tourCategory;

    public Tour() {}

    public Tour(int tourId, String tourName, double price, LocalDateTime dateTime, String duration, double rating) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.price = price;
        this.dateTime = dateTime;
        this.duration = duration;
        this.rating = rating;
    }

    // Геттери та сеттери
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public int getMaxGroupSize() { return maxGroupSize; }
    public void setMaxGroupSize(int maxGroupSize) { this.maxGroupSize = maxGroupSize; }

    public String getDifficultyLevel() { return difficultyLevel; }
    public void setDifficultyLevel(String difficultyLevel) { this.difficultyLevel = difficultyLevel; }

    public String getDetailedDescription() { return detailedDescription; }
    public void setDetailedDescription(String detailedDescription) { this.detailedDescription = detailedDescription; }

    public String getTourCategory() { return tourCategory; }
    public void setTourCategory(String tourCategory) { this.tourCategory = tourCategory; }


    @Override
    public String toString() {
        return tourName;
    }

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }


}
