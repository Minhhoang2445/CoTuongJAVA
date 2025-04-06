package com.example.cotuong.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    // Sự kiện khi nhấn nút "Chơi"
    @FXML
    private void handlePlay(ActionEvent event) {
        try {
            // Tải GameScreen.fxml
            Parent gameScreenRoot = FXMLLoader.load(getClass().getResource("/com/example/cotuong/GameScreen.fxml"));

            // Tạo scene mới với giao diện game
            Scene gameScene = new Scene(gameScreenRoot, 800, 600); // Có thể thay đổi kích thước cửa sổ game
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Lấy Stage hiện tại

            // Chuyển sang màn hình game
            currentStage.setScene(gameScene);
            currentStage.setTitle("Game Cờ Tướng");
            currentStage.show();  // Hiển thị cửa sổ mới
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Sự kiện khi nhấn nút "Cài đặt"
    @FXML
    private void handleSettings(ActionEvent event) {
        // Mở màn hình cài đặt
        System.out.println("Mở màn hình cài đặt");
        // Ví dụ: Chuyển sang màn hình Settings
        // YourApp.changeScene("settings.fxml");
    }

    // Sự kiện khi nhấn nút "Lịch sử đấu"
    @FXML
    private void handleHistory(ActionEvent event) {
        // Hiển thị lịch sử đấu hoặc thực hiện hành động nào đó
        System.out.println("Hiển thị lịch sử đấu");
        // Ví dụ: Chuyển sang màn hình lịch sử
        // YourApp.changeScene("history.fxml");
    }

    // Sự kiện khi nhấn nút "Thoát"
    @FXML
    private void handleExit(ActionEvent event) {
        // Hiển thị hộp thoại xác nhận trước khi thoát
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Thoát game");
        alert.setHeaderText("Bạn có chắc chắn muốn thoát?");
        alert.showAndWait().ifPresent(response -> {
            if (response == javafx.scene.control.ButtonType.OK) {
                // Đóng ứng dụng khi người dùng xác nhận thoát
                System.exit(0);
            }
        });
    }
}
