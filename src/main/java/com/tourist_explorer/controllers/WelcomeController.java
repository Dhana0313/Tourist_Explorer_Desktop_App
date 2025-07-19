package com.tourist_explorer.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.tourist_explorer.Main;

public class WelcomeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void goToContent(ActionEvent event) {
        try {
            Main.changeScene("view/Content.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            //showAlert("Navigation Error", "Unable to load content screen.");
        }
    }
}