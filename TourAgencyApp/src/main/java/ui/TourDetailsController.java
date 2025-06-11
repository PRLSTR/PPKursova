package ui;

import com.touragency.model.Tour;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.awt.event.ActionEvent;

public class TourDetailsController {

    @FXML
    private Label tourIdLabel;

    @FXML
    private Label tourNameLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label durationLabel;

    @FXML
    private Label dateTimeLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label languageLabel;

    @FXML
    private Label maxGroupSizeLabel;

    @FXML
    private Label difficultyLevelLabel;

    @FXML
    private Label detailedDescriptionLabel;

    @FXML
    private Label tourTypeLabel;

    @FXML
    private Label ratingLabel;

    @FXML
    private Label tourCategoryLabel;




    /**
     * Метод для встановлення даних туру у UI.
     * Викликається зовні після завантаження FXML.
     */
    public void setTour(Tour tour) {
        if (tour == null) {
            clearLabels();
            return;
        }
        tourIdLabel.setText(String.valueOf(tour.getTourId()));
        tourNameLabel.setText(tour.getTourName());
        descriptionLabel.setText(tour.getDescription());
        priceLabel.setText(String.format("%.2f", tour.getPrice()));
        durationLabel.setText(tour.getDuration());
        dateTimeLabel.setText(tour.getDateTime() != null ? tour.getDateTime().toString() : "");
        typeLabel.setText(tour.getType());
        languageLabel.setText(tour.getLanguage());
        maxGroupSizeLabel.setText(String.valueOf(tour.getMaxGroupSize()));
        difficultyLevelLabel.setText(tour.getDifficultyLevel());
        detailedDescriptionLabel.setText(tour.getDetailedDescription());
        tourTypeLabel.setText(tour.getTourType());
        ratingLabel.setText(String.format("%.1f", tour.getRating()));
        tourCategoryLabel.setText(tour.getTourCategory());
    }

    /**
     * Очищає всі лейбли.
     */
    private void clearLabels() {
        tourIdLabel.setText("");
        tourNameLabel.setText("");
        descriptionLabel.setText("");
        priceLabel.setText("");
        durationLabel.setText("");
        dateTimeLabel.setText("");
        typeLabel.setText("");
        languageLabel.setText("");
        maxGroupSizeLabel.setText("");
        difficultyLevelLabel.setText("");
        detailedDescriptionLabel.setText("");
        tourTypeLabel.setText("");
        ratingLabel.setText("");
        tourCategoryLabel.setText("");
    }

    private TabPane mainTabPane;
    private Tab currentTab;

    public void setMainTabPane(TabPane mainTabPane) {
        this.mainTabPane = mainTabPane;
    }

    public void setCurrentTab(Tab currentTab) {
        this.currentTab = currentTab;
    }

    @FXML
    private void handleCloseTab() {
        if (mainTabPane != null && currentTab != null) {
            mainTabPane.getTabs().remove(currentTab);
        }

        for (Tab tab : mainTabPane.getTabs()) {
            if ("Tours".equals(tab.getText())) {
                mainTabPane.getSelectionModel().select(tab);
                break;
            }
        }
    }
}
