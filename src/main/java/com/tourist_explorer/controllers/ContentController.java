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

}