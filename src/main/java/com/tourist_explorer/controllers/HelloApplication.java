package com.example.welcome2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        // Lock the window to the specified dimensions
        stage.setResizable(true);
        stage.setMinWidth(600);
        stage.setMaxWidth(1920);
        stage.setMinHeight(400);
        stage.setMaxHeight(1080);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
