package com.touragency;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Завантажуємо FXML файл
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/touragency/ui/MainView.fxml"));

            // Створюємо сцену з завантаженим FXML
            Scene scene = new Scene(loader.load());

            // Налаштовуємо головне вікно
            primaryStage.setTitle("Tour Agency Management");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Error loading FXML file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Підключення до бази даних
            Connection conn = DBConnection.getConnection();
            System.out.println("Connected to DB successfully!");

            // Запускаємо JavaFX додаток
            launch(args);

            conn.close();
        } catch (Exception e) {
            System.out.println("Something went wrong with the database connection!");
            e.printStackTrace();
        }
    }
}
