package com.tourist_explorer.controllers;

import com.tourist_explorer.Main;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class ContentController {
    public void goBack(ActionEvent actionEvent) {
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

    public void goBackk(MouseEvent mouseEvent) {
        try{
            Main.changeScene("view/Content.fxml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
