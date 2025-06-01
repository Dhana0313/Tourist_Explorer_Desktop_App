package com.tourist_explorer.controllers;

import com.tourist_explorer.Main;
import javafx.event.ActionEvent;

public class ContentController {
    public void goBack(ActionEvent event) {
        try{
            Main.changeScene("view/Welcome.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void signUp(ActionEvent event) {
        try{
            Main.changLogSign("view/SignupView.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void login(ActionEvent event) {
        try{
            Main.changLogSign("view/LoginView.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
