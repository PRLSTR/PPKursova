package ui;

import com.touragency.db.DBHelper;
import com.touragency.dialog.BookingDialog;
import com.touragency.dialog.GuideDialog;
import com.touragency.dialog.TourDialog;
import com.touragency.model.Booking;
import com.touragency.model.Guide;
import com.touragency.model.Tour;
import com.touragency.util.AlertHelper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MainViewController {

    // Tours Table
    @FXML private TableView<Tour> toursTableView;

    @FXML private TableColumn<Tour, String> tourNameColumn;

    @FXML private TableColumn<Tour, Double> priceColumn;

    @FXML private TableColumn<Tour, LocalDate> dateTimeColumn;;

    @FXML private TableColumn<Tour, String> durationColumn;

    @FXML private TableColumn<Tour, Double> ratingColumn;

    @FXML private TableColumn<Tour, String> tourTypeColumn;

    // Guides Table
    @FXML private TableView<Guide> guidesTableView;

    @FXML private TableColumn<Guide, Integer> guideIdColumn;

    @FXML private TableColumn<Guide, String> firstNameColumn;

    @FXML private TableColumn<Guide, String> lastNameColumn;

    @FXML private TableColumn<Guide, String> phoneNumberColumn;

    @FXML private TableColumn<Guide, String> emailColumn;

    @FXML private TableColumn<Guide, Integer> experienceYearsColumn;

    @FXML private TableColumn<Guide, String> specializationColumn;

    // Bookings Table
    @FXML private TableView<Booking> bookingsTableView;

    @FXML private TableColumn<Booking, Integer> bookingIdColumn;

    @FXML private TableColumn<Booking, Integer> touristIdColumn;

    @FXML private TableColumn<Booking, Integer> tourIdColumn;

    @FXML private TableColumn<Booking, LocalDateTime> bookingDateColumn;

    @FXML private TableColumn<Booking, Integer> numberOfPeopleColumn;

    @FXML private TableColumn<Booking, Double> totalPriceColumn;

    @FXML private TabPane mainTabPane;



    @FXML private TextField filterTourNameField;

    @FXML private ComboBox<String> filterTourTypeComboBox;

    @FXML private DatePicker filterDateFromPicker;

    @FXML private DatePicker filterDateToPicker;

    @FXML private Tab currentTab;

    @FXML private Button filterApplyButton;

    @FXML private ObservableList<Tour> masterTourList = FXCollections.observableArrayList();
    @FXML private Button filterResetButton;

    @FXML
    private void onTourTypeComboBoxShowing() {
        updateTourTypeComboBox();
    }

    @FXML
    private void handleFilterTours(ActionEvent event) {
        // Логіка фільтрації — наприклад:
        String nameFilter = filterTourNameField.getText().toLowerCase();
        String typeFilter = filterTourTypeComboBox.getValue();
        LocalDate dateFrom = filterDateFromPicker.getValue();
        LocalDate dateTo = filterDateToPicker.getValue();

        ObservableList<Tour> filteredList = FXCollections.observableArrayList();

        for (Tour t : masterTourList) {
            boolean matches = true;

            if (nameFilter != null && !nameFilter.isEmpty()) {
                matches &= t.getTourName().toLowerCase().contains(nameFilter);
            }
            if (typeFilter != null && !typeFilter.isEmpty()) {
                matches &= t.getTourType() != null && t.getTourType().equals(typeFilter);
            }
            if (dateFrom != null) {
                matches &= !t.getDateTime().toLocalDate().isBefore(dateFrom);
            }
            if (dateTo != null) {
                matches &= !t.getDateTime().toLocalDate().isAfter(dateTo);
            }

            if (matches) {
                filteredList.add(t);
            }

            if (typeFilter != null && !typeFilter.isEmpty()) {
                matches &= t.getTourType() != null && t.getTourType().equals(typeFilter);
            }
        }

        toursTableView.setItems(filteredList);
    }

    @FXML
    private void handleResetFilters(ActionEvent event) {
        // Очищаємо всі поля фільтрів
        filterTourNameField.clear();
        filterTourTypeComboBox.getSelectionModel().clearSelection();
        filterDateFromPicker.setValue(null);
        filterDateToPicker.setValue(null);

        // Відновлюємо повний список турів у таблиці
        toursTableView.setItems(masterTourList);
    }

    // Обробники меню
    @FXML
    private void handleAddTour(ActionEvent event) {
        // Приклад: відкриваємо діалог для введення даних нового туру
        Tour newTour = TourDialog.showAddDialog();
        if (newTour != null) {
            // Додаємо у БД (потрібно реалізувати DBInsert)
            DBHelper.insertTour(newTour);
            // Оновлюємо таблицю
            toursTableView.getItems().add(newTour);
        }
    }

    @FXML
    private void handleEditTour(ActionEvent event) {
        Tour selectedTour = toursTableView.getSelectionModel().getSelectedItem();
        if (selectedTour != null) {
            Tour editedTour = TourDialog.showEditDialog(selectedTour);
            if (editedTour != null) {
                // Оновлюємо в БД
                DBHelper.updateTour(editedTour);
                // Оновлюємо елемент у таблиці (перезаписуємо)
                int index = toursTableView.getItems().indexOf(selectedTour);
                toursTableView.getItems().set(index, editedTour);
            }
        } else {
            // Повідомлення користувачу, що нічого не вибрано
            com.touragency.util.AlertHelper.showWarning("Виберіть тур для редагування.");
        }
    }

    @FXML
    private void handleDeleteTour(ActionEvent event) {
        Tour selectedTour = toursTableView.getSelectionModel().getSelectedItem();
        if (selectedTour != null) {
            boolean confirmed = com.touragency.util.AlertHelper.showConfirmation("Видалити тур " + selectedTour.getTourName() + "?");
            if (confirmed) {
                // Видаляємо з БД
                DBHelper.deleteTour(selectedTour.getTourId());
                // Видаляємо з таблиці
                toursTableView.getItems().remove(selectedTour);
            }
        } else {
            com.touragency.util.AlertHelper.showWarning("Виберіть тур для видалення.");
        }
    }

    @FXML
    private void handleAddGuide(ActionEvent event) {
        Guide newGuide = GuideDialog.showAddDialog(); // Реалізуй аналогічний TourDialog для Guide
        if (newGuide != null) {
            DBHelper.insertGuide(newGuide);  // Реалізуй insertGuide в DBHelper
            guidesTableView.getItems().add(newGuide);
        }
    }

    @FXML
    private void handleEditGuide(ActionEvent event) {
        Guide selectedGuide = guidesTableView.getSelectionModel().getSelectedItem();
        if (selectedGuide != null) {
            Guide editedGuide = GuideDialog.showEditDialog(selectedGuide);
            if (editedGuide != null) {
                DBHelper.updateGuide(editedGuide); // Реалізуй updateGuide в DBHelper
                int index = guidesTableView.getItems().indexOf(selectedGuide);
                guidesTableView.getItems().set(index, editedGuide);
            }
        } else {
            AlertHelper.showWarning("Виберіть гіда для редагування.");
        }
    }

    @FXML
    private void handleDeleteGuide(ActionEvent event) {
        Guide selectedGuide = guidesTableView.getSelectionModel().getSelectedItem();
        if (selectedGuide != null) {
            boolean confirmed = AlertHelper.showConfirmation("Видалити гіда " + selectedGuide.getFirstName() + " " + selectedGuide.getLastName() + "?");
            if (confirmed) {
                DBHelper.deleteGuide(selectedGuide.getGuideId()); // Реалізуй deleteGuide в DBHelper
                guidesTableView.getItems().remove(selectedGuide);
            }
        } else {
            AlertHelper.showWarning("Виберіть гіда для видалення.");
        }
    }

    @FXML
    private void handleAddBooking(ActionEvent event) {
        Booking newBooking = BookingDialog.showAddDialog(); // Реалізуй BookingDialog як TourDialog
        if (newBooking != null) {
            DBHelper.insertBooking(newBooking); // Реалізуй insertBooking в DBHelper
            bookingsTableView.getItems().add(newBooking);
        }
    }

    @FXML
    private void handleEditBooking(ActionEvent event) {
        Booking selectedBooking = bookingsTableView.getSelectionModel().getSelectedItem();
        if (selectedBooking != null) {
            Booking editedBooking = BookingDialog.showEditDialog(selectedBooking);
            if (editedBooking != null) {
                DBHelper.updateBooking(editedBooking); // Реалізуй updateBooking в DBHelper
                int index = bookingsTableView.getItems().indexOf(selectedBooking);
                bookingsTableView.getItems().set(index, editedBooking);
            }
        } else {
            AlertHelper.showWarning("Виберіть бронювання для редагування.");
        }
    }

    @FXML
    private void handleDeleteBooking(ActionEvent event) {
        Booking selectedBooking = bookingsTableView.getSelectionModel().getSelectedItem();
        if (selectedBooking != null) {
            boolean confirmed = AlertHelper.showConfirmation("Видалити бронювання №" + selectedBooking.getBookingId() + "?");
            if (confirmed) {
                DBHelper.deleteBooking(selectedBooking.getBookingId()); // Реалізуй deleteBooking в DBHelper
                bookingsTableView.getItems().remove(selectedBooking);
            }
        } else {
            AlertHelper.showWarning("Виберіть бронювання для видалення.");
        }
    }

    @FXML
    private void updateTourTypeComboBox() {
        List<String> types = DBHelper.getDistinctTourTypes();

        // Очищуємо поточні елементи, щоб уникнути дублікатів
        filterTourTypeComboBox.getItems().clear();

        // Додаємо типи з БД
        filterTourTypeComboBox.getItems().addAll(types);
    }

    @FXML
    private void openTourDetails(Tour tour) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/touragency/ui/TourDetailsView.fxml"));
            Parent root = loader.load();

            TourDetailsController controller = loader.getController();
            controller.setTour(tour);

            Tab detailsTab = new Tab("Деталі туру");
            detailsTab.setContent(root);

            // Ось тут мають бути виклики:
            controller.setMainTabPane(mainTabPane);
            controller.setCurrentTab(detailsTab);

            mainTabPane.getTabs().add(detailsTab);
            mainTabPane.getSelectionModel().select(detailsTab);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setMainTabPane(TabPane mainTabPane) {
        this.mainTabPane = mainTabPane;
    }

    public void setCurrentTab(Tab currentTab) {
        this.currentTab = currentTab;
    }

    // Метод ініціалізації контролера (викликається автоматично після завантаження FXML)
    @FXML
    private void initialize() {
        // Tours
        tourNameColumn.setCellValueFactory(new PropertyValueFactory<>("tourName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateTimeColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue().getDateTime() != null) {
                return new ReadOnlyObjectWrapper<>(cellData.getValue().getDateTime().toLocalDate());
            } else {
                return null;
            }
        });
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        tourTypeColumn.setCellValueFactory(new PropertyValueFactory<>("tourType"));
        masterTourList.setAll(DBHelper.getAllTours());
        toursTableView.setItems(masterTourList);

        // Guides
        guideIdColumn.setCellValueFactory(new PropertyValueFactory<>("guideId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        experienceYearsColumn.setCellValueFactory(new PropertyValueFactory<>("experienceYears"));
        specializationColumn.setCellValueFactory(new PropertyValueFactory<>("specialization"));

        guidesTableView.setItems(FXCollections.observableArrayList(DBHelper.getAllGuides()));

        // Bookings
        bookingIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        touristIdColumn.setCellValueFactory(new PropertyValueFactory<>("touristId"));
        tourIdColumn.setCellValueFactory(new PropertyValueFactory<>("tourId"));
        bookingDateColumn.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        numberOfPeopleColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfPeople"));
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        filterTourTypeComboBox.getItems().addAll("Культурний", "Екскурсійний", "Тип 3");

        bookingsTableView.setItems(FXCollections.observableArrayList(DBHelper.getAllBookings()));

        toursTableView.setRowFactory(tv -> {
            TableRow<Tour> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Tour selectedTour = row.getItem();
                    openTourDetails(selectedTour);
                }
            });
            return row;
        });


    }
}
