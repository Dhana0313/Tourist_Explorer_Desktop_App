package com.tourist_explorer.controllers;

import com.tourist_explorer.Main;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class ContentController {
    public void goBack(MouseEvent mouseEvent) {
        try{
            Main.changeScene("view/Welcome.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void signUp(MouseEvent mouseEvent) {
        try{
            Main.changLogSign("view/SignupView.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void login(MouseEvent mouseEvent) {
        try{
            Main.changLogSign("view/LoginView.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void pageLoad(MouseEvent mouseEvent) {
        try{
            Main.changeScene("view/Mirissa.fxml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
