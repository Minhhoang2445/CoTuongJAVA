package com.example.cotuong;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BanCo.fxml")));
            Scene scene = new Scene(root,600,600);
            scene.getStylesheets().add(getClass().getResource("BanCo.css").toExternalForm());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("JavaFX Runtime Version: " + System.getProperty("javafx.runtime.version"));
        launch();
    }
}