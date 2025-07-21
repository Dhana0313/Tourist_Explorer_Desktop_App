package com.tourist_explorer.controllers;

import com.tourist_explorer.Main;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import com.tourist_explorer.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader; // Add this import
import javafx.scene.Parent; // Add this import
import javafx.scene.Scene; // Add this import
import javafx.scene.control.Alert;
import javafx.stage.Stage; // Add this import

import java.io.IOException; // Add this import

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContentController {
    public void goBack(ActionEvent actionEvent) {
        try{
            Main.changeScene("view/Welcome.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void signUp(ActionEvent actionEvent) {
        try{
            Main.changLogSign("view/SignUpView.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void login(ActionEvent actionEvent) {
        try{
            Main.changLogSign("view/LoginView.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void pageLoad(MouseEvent mouseEvent) {
        try{
            Main.changeScene("view/MirissaBeach.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void backToMain(ActionEvent actionEvent) {
        try{
            Main.changeScene("view/Content.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addToCart(ActionEvent actionEvent) {
        try{
            Main.changeScene("view/Cart.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void backFromCart(ActionEvent actionEvent) {
        try{
            Main.changeScene("view/MirissaBeach.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void openCartPage(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tourist_explorer/view/Cart.fxml"));
            Parent cartRoot = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Your Cart");
            stage.setScene(new Scene(cartRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // ============ ADD TO CART BUTTONS =============

    @FXML
    private void addSurfingToCart(ActionEvent event) {
        insertIntoCart("Surfing", 1000.0);
    }

    @FXML
    private void addWhaleWatchingToCart(ActionEvent event) {
        insertIntoCart("Whale Watching", 7500.0);
    }

    // ============ INSERT INTO DATABASE =============

    private void insertIntoCart(String packageName, double price) {
        String query = "INSERT INTO cart (package_name, price) VALUES (?, ?)";

        try {
            // ✅ Create an instance of DatabaseConnection
            DatabaseConnection dbConn = new DatabaseConnection();
            Connection conn = dbConn.getConnection();

            if (conn != null) {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, packageName);
                stmt.setDouble(2, price);
                stmt.executeUpdate();

                // ✅ Success alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cart");
                alert.setHeaderText(null);
                alert.setContentText(packageName + " added to cart successfully!");
                alert.showAndWait();
            } else {
                showError("Database connection failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            showError("Failed to add " + packageName + " to cart.");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}