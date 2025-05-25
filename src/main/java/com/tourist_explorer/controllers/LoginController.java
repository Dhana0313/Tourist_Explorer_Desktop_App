package com.tourist_explorer.controllers;

import com.tourist_explorer.DatabaseConnection;
import com.tourist_explorer.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    @FXML
    public void handleLogin(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Login Error", "Please enter both username and password.");
            return;
        }

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Successful login
                Main.changeScene("view/MainDashboard.fxml");
            } else {
                // Failed login
                showAlert("Login Failed", "Invalid username or password.");
            }

            statement.close();
            resultSet.close();
            connectDB.close();

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Something went wrong. Please try again.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void goToSignup(ActionEvent event) {
        try {
            Main.changeScene("view/SignupView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Unable to open signup screen.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
