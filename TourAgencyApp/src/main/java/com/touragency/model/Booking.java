package com.touragency.model;

import java.time.LocalDateTime;

// Модель Booking
public class Booking {
    private int bookingId;
    private int touristId;
    private int tourId;
    private LocalDateTime bookingDate;
    private int numberOfPeople;
    private double totalPrice;

    public Booking() {}

    public Booking(int bookingId, int touristId, int tourId, LocalDateTime bookingDate, int numberOfPeople, double totalPrice) {
        this.bookingId = bookingId;
        this.touristId = touristId;
        this.tourId = tourId;
        this.bookingDate = bookingDate;
        this.numberOfPeople = numberOfPeople;
        this.totalPrice = totalPrice;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getTouristId() {
        return touristId;
    }

    public void setTouristId(int touristId) {
        this.touristId = touristId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
