package com.tourist_explorer.controllers;

import javafx.beans.property.*;

public class CartItem {
    private final StringProperty packageName;
    private final DoubleProperty price;
    private final IntegerProperty quantity;

    public CartItem(String packageName, double price, int quantity) {
        this.packageName = new SimpleStringProperty(packageName);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public StringProperty packageNameProperty() { return packageName; }
    public DoubleProperty priceProperty() { return price; }
    public IntegerProperty quantityProperty() { return quantity; }
}