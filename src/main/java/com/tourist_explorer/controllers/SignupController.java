package com.tourist_explorer.controllers;

import com.tourist_explorer.DatabaseConnection;
import com.tourist_explorer.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private TextField emailField;

    @FXML
    private void handleSignup(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String confirmPassword = confirmPasswordField.getText().trim();
        String email = emailField.getText().trim();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            showAlert("Signup Error", "All fields are required.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert("Signup Error", "Passwords do not match.");
            return;
        }

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String insertQuery = "INSERT INTO users(username, password, email) VALUES(?, ?, ?)";

        try {
            PreparedStatement statement = connectDB.prepareStatement(insertQuery);
            statement.setString(1, username);
            statement.setString(2, password);  // Optionally hash this
            statement.setString(3, email);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                showAlert("Success", "Account created successfully. You can now log in.");
                Main.changeScene("view/LoginView.fxml");
            } else {
                showAlert("Signup Failed", "Could not create user. Try again.");
            }

            statement.close();
            connectDB.close();

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "User may already exist or database error.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void goToLogin(ActionEvent event) {
        try {
            Main.changeScene("view/LoginView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Unable to load login screen.");
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
