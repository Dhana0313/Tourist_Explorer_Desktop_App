package com.tourist_explorer.controllers;

import com.tourist_explorer.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML private TableView<CartItem> cartTable;
    @FXML private TableColumn<CartItem, String> nameColumn;
    @FXML private TableColumn<CartItem, Double> priceColumn;
    @FXML private TableColumn<CartItem, Integer> quantityColumn;
    @FXML private TextField subtotalField;

    private ObservableList<CartItem> cartItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().packageNameProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());

        loadCartItems();
    }

    private void loadCartItems() {
        double subtotal = 0.0;

        try {
            Connection conn = new DatabaseConnection().getConnection();
            if (conn != null) {
                String sql = "SELECT package_name, price FROM cart";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("package_name");
                    double price = rs.getDouble("price");
                    int quantity = 1; // default quantity 1
                    subtotal += price;

                    cartItems.add(new CartItem(name, price, quantity));
                }

                cartTable.setItems(cartItems);
                subtotalField.setText(String.format("LKR %.2f", subtotal));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        // Close current stage (cart window)
        Stage stage = (Stage) cartTable.getScene().getWindow();
        stage.close();
    }
}