package com.touragency.dialog;

import com.touragency.model.Booking;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class BookingDialog {

    public static Booking showAddDialog() {
        return showBookingDialog(null);
    }

    public static Booking showEditDialog(Booking booking) {
        return showBookingDialog(booking);
    }

    private static Booking showBookingDialog(Booking booking) {
        Dialog<Booking> dialog = new Dialog<>();
        dialog.setTitle(booking == null ? "Додати бронювання" : "Редагувати бронювання");

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        TextField touristIdField = new TextField();
        TextField tourIdField = new TextField();
        TextField bookingDateField = new TextField();
        TextField numberOfPeopleField = new TextField();
        TextField totalPriceField = new TextField();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if (booking != null) {
            touristIdField.setText(String.valueOf(booking.getTouristId()));
            tourIdField.setText(String.valueOf(booking.getTourId()));
            bookingDateField.setText(booking.getBookingDate().format(formatter));
            numberOfPeopleField.setText(String.valueOf(booking.getNumberOfPeople()));
            totalPriceField.setText(String.valueOf(booking.getTotalPrice()));
        }

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("ID туриста:"), 0, 0);
        grid.add(touristIdField, 1, 0);
        grid.add(new Label("ID туру:"), 0, 1);
        grid.add(tourIdField, 1, 1);
        grid.add(new Label("Дата бронювання (yyyy-MM-dd HH:mm):"), 0, 2);
        grid.add(bookingDateField, 1, 2);
        grid.add(new Label("Кількість осіб:"), 0, 3);
        grid.add(numberOfPeopleField, 1, 3);
        grid.add(new Label("Загальна ціна:"), 0, 4);
        grid.add(totalPriceField, 1, 4);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                try {
                    Booking b = new Booking();
                    if (booking != null) b.setBookingId(booking.getBookingId());
                    b.setTouristId(Integer.parseInt(touristIdField.getText()));
                    b.setTourId(Integer.parseInt(tourIdField.getText()));
                    b.setBookingDate(LocalDateTime.parse(bookingDateField.getText(), formatter));
                    b.setNumberOfPeople(Integer.parseInt(numberOfPeopleField.getText()));
                    b.setTotalPrice(Double.parseDouble(totalPriceField.getText()));
                    return b;
                } catch (Exception e) {
                    return null;
                }
            }
            return null;
        });

        Optional<Booking> result = dialog.showAndWait();
        return result.orElse(null);
    }
}
