package com.touragency.dialog;

import com.touragency.model.Tour;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class TourDialog {

    public static Tour showAddDialog() {
        return showTourDialog(null);
    }

    public static Tour showEditDialog(Tour tour) {
        return showTourDialog(tour);
    }

    private static Tour showTourDialog(Tour tour) {
        Dialog<Tour> dialog = new Dialog<>();
        dialog.setTitle(tour == null ? "Додати тур" : "Редагувати тур");

        // Кнопки
        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        // Поля вводу
        TextField tourNameField = new TextField();
        TextField priceField = new TextField();
        TextField dateTimeField = new TextField();
        TextField durationField = new TextField();
        TextField ratingField = new TextField();

        // Заповнити поля, якщо редагування
        if (tour != null) {
            tourNameField.setText(tour.getTourName());
            priceField.setText(String.valueOf(tour.getPrice()));
            dateTimeField.setText(tour.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            durationField.setText(tour.getDuration());
            ratingField.setText(String.valueOf(tour.getRating()));
        }

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Назва туру:"), 0, 0);
        grid.add(tourNameField, 1, 0);
        grid.add(new Label("Ціна:"), 0, 1);
        grid.add(priceField, 1, 1);
        grid.add(new Label("Дата і час (yyyy-MM-dd HH:mm):"), 0, 2);
        grid.add(dateTimeField, 1, 2);
        grid.add(new Label("Тривалість:"), 0, 3);
        grid.add(durationField, 1, 3);
        grid.add(new Label("Оцінка:"), 0, 4);
        grid.add(ratingField, 1, 4);

        dialog.getDialogPane().setContent(grid);

        // Конвертер результату
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                try {
                    Tour t = new Tour();
                    if (tour != null) t.setTourId(tour.getTourId()); // Зберегти id при редагуванні
                    t.setTourName(tourNameField.getText());
                    t.setPrice(Double.parseDouble(priceField.getText()));
                    t.setDateTime(LocalDateTime.parse(dateTimeField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                    t.setDuration(durationField.getText());
                    t.setRating(Double.parseDouble(ratingField.getText()));
                    return t;
                } catch (Exception e) {
                    System.out.println("Щось пішло не так!" + e.getMessage());
                    return null;
                }
            }
            return null;
        });

        Optional<Tour> result = dialog.showAndWait();

        return result.orElse(null);
    }
}
