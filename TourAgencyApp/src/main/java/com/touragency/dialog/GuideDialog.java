package com.touragency.dialog;

import com.touragency.model.Guide;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class GuideDialog {

    public static Guide showAddDialog() {
        return showGuideDialog(null);
    }

    public static Guide showEditDialog(Guide guide) {
        return showGuideDialog(guide);
    }

    private static Guide showGuideDialog(Guide guide) {
        Dialog<Guide> dialog = new Dialog<>();
        dialog.setTitle(guide == null ? "Додати гіда" : "Редагувати гіда");

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField phoneField = new TextField();
        TextField emailField = new TextField();
        TextField experienceField = new TextField();
        TextField specializationField = new TextField();

        if (guide != null) {
            firstNameField.setText(guide.getFirstName());
            lastNameField.setText(guide.getLastName());
            phoneField.setText(guide.getPhoneNumber());
            emailField.setText(guide.getEmail());
            experienceField.setText(String.valueOf(guide.getExperienceYears()));
            specializationField.setText(guide.getSpecialization());
        }

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Ім'я:"), 0, 0);
        grid.add(firstNameField, 1, 0);
        grid.add(new Label("Прізвище:"), 0, 1);
        grid.add(lastNameField, 1, 1);
        grid.add(new Label("Телефон:"), 0, 2);
        grid.add(phoneField, 1, 2);
        grid.add(new Label("Email:"), 0, 3);
        grid.add(emailField, 1, 3);
        grid.add(new Label("Досвід (роки):"), 0, 4);
        grid.add(experienceField, 1, 4);
        grid.add(new Label("Спеціалізація:"), 0, 5);
        grid.add(specializationField, 1, 5);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                try {
                    Guide g = new Guide();
                    if (guide != null) g.setGuideId(guide.getGuideId());
                    g.setFirstName(firstNameField.getText());
                    g.setLastName(lastNameField.getText());
                    g.setPhoneNumber(phoneField.getText());
                    g.setEmail(emailField.getText());
                    g.setExperienceYears(Integer.parseInt(experienceField.getText()));
                    g.setSpecialization(specializationField.getText());
                    return g;
                } catch (Exception e) {
                    return null;
                }
            }
            return null;
        });

        Optional<Guide> result = dialog.showAndWait();
        return result.orElse(null);
    }
}
