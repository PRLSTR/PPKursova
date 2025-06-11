package com.touragency.db;

import com.touragency.DBConnection;
import com.touragency.model.Booking;
import com.touragency.model.Guide;
import com.touragency.model.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    public static void insertTour(Tour tour) {
        String sql = "INSERT INTO Tour (tour_id, tour_name, price, date_time, duration, rating) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, tour.getTourId());
            stmt.setString(2, tour.getTourName());
            stmt.setDouble(3, tour.getPrice());
            stmt.setObject(4, tour.getDateTime());
            stmt.setString(5, tour.getDuration());
            stmt.setDouble(6, tour.getRating());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Можна додати логування або кидати RuntimeException
        }
    }

    public static void updateTour(Tour tour) {
        String sql = "UPDATE Tour SET tour_name=?, price=?, date_time=?, duration=?, rating=? WHERE tour_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tour.getTourName());
            stmt.setDouble(2, tour.getPrice());
            stmt.setObject(3, tour.getDateTime());
            stmt.setString(4, tour.getDuration());
            stmt.setDouble(5, tour.getRating());
            stmt.setInt(6, tour.getTourId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTour(int tourId) {
        String sql = "DELETE FROM Tour WHERE tour_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, tourId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Tour> getAllTours() {
        List<Tour> tours = new ArrayList<>();
        String sql = "SELECT tour_id, tour_name, price, date_time, duration, rating, tour_type, " +
                "description, type, language, max_group_size, difficulty_level, detailed_description, tour_category " +
                "FROM Tour";


        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tour t = new Tour();
                t.setTourId(rs.getInt("tour_id"));
                t.setTourName(rs.getString("tour_name"));
                t.setPrice(rs.getDouble("price"));
                t.setDateTime(rs.getTimestamp("date_time").toLocalDateTime());
                t.setDuration(rs.getString("duration"));
                t.setTourType(rs.getString("tour_type"));
                t.setRating(rs.getDouble("rating"));
                t.setDescription(rs.getString("description"));
                t.setType(rs.getString("type"));
                t.setLanguage(rs.getString("language"));
                t.setMaxGroupSize(rs.getInt("max_group_size"));
                t.setDifficultyLevel(rs.getString("difficulty_level"));
                t.setDetailedDescription(rs.getString("detailed_description"));
                t.setTourCategory(rs.getString("tour_category"));

                tours.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }
    public static List<Guide> getAllGuides() {
        List<Guide> guides = new ArrayList<>();
        String sql = "SELECT guide_id, first_name, last_name, phone_number, email, experience_years, specialization FROM Guide";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Guide g = new Guide();
                g.setGuideId(rs.getInt("guide_id"));
                g.setFirstName(rs.getString("first_name"));
                g.setLastName(rs.getString("last_name"));
                g.setPhoneNumber(rs.getString("phone_number"));
                g.setEmail(rs.getString("email"));
                g.setExperienceYears(rs.getInt("experience_years"));
                g.setSpecialization(rs.getString("specialization"));
                guides.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guides;
    }

    public static List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT booking_id, tourist_id, tour_id, booking_date, number_of_people, total_price FROM Booking";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Booking b = new Booking();
                b.setBookingId(rs.getInt("booking_id"));
                b.setTouristId(rs.getInt("tourist_id"));
                b.setTourId(rs.getInt("tour_id"));
                b.setBookingDate(rs.getTimestamp("booking_date").toLocalDateTime());
                b.setNumberOfPeople(rs.getInt("number_of_people"));
                b.setTotalPrice(rs.getDouble("total_price"));
                bookings.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public static void insertGuide(Guide guide) {
        String sql = "INSERT INTO Guide (guide_id, first_name, last_name, phone_number, email, experience_years, specialization) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, guide.getGuideId());
            stmt.setString(2, guide.getFirstName());
            stmt.setString(3, guide.getLastName());
            stmt.setString(4, guide.getPhoneNumber());
            stmt.setString(5, guide.getEmail());
            stmt.setInt(6, guide.getExperienceYears());
            stmt.setString(7, guide.getSpecialization());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateGuide(Guide guide) {
        String sql = "UPDATE Guide SET first_name=?, last_name=?, phone_number=?, email=?, experience_years=?, specialization=? WHERE guide_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, guide.getFirstName());
            stmt.setString(2, guide.getLastName());
            stmt.setString(3, guide.getPhoneNumber());
            stmt.setString(4, guide.getEmail());
            stmt.setInt(5, guide.getExperienceYears());
            stmt.setString(6, guide.getSpecialization());
            stmt.setInt(7, guide.getGuideId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteGuide(int guideId) {
        String sql = "DELETE FROM Guide WHERE guide_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, guideId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertBooking(Booking booking) {
        String sql = "INSERT INTO Booking (booking_id, tourist_id, tour_id, booking_date, number_of_people, total_price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, booking.getBookingId());
            stmt.setInt(2, booking.getTouristId());
            stmt.setInt(3, booking.getTourId());
            stmt.setObject(4, booking.getBookingDate());
            stmt.setInt(5, booking.getNumberOfPeople());
            stmt.setDouble(6, booking.getTotalPrice());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBooking(Booking booking) {
        String sql = "UPDATE Booking SET tourist_id=?, tour_id=?, booking_date=?, number_of_people=?, total_price=? WHERE booking_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, booking.getTouristId());
            stmt.setInt(2, booking.getTourId());
            stmt.setObject(3, booking.getBookingDate());
            stmt.setInt(4, booking.getNumberOfPeople());
            stmt.setDouble(5, booking.getTotalPrice());
            stmt.setInt(6, booking.getBookingId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBooking(int bookingId) {
        String sql = "DELETE FROM Booking WHERE booking_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookingId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getDistinctTourTypes() {
        List<String> types = new ArrayList<>();
        String sql = "SELECT DISTINCT tour_type FROM Tour";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String type = rs.getString("tour_type");
                if (type != null && !type.isEmpty()) {
                    types.add(type);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }
}
