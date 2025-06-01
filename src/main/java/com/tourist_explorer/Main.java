package com.tourist_explorer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setResizable(false);
        changeScene("view/Welcome.fxml");
    }

    public static void changeScene(String fxmlFile) throws Exception {
        Parent pane = FXMLLoader.load(Main.class.getResource(fxmlFile));
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Boat Booking System");
        primaryStage.setWidth(1480);
        primaryStage.setHeight(820);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
