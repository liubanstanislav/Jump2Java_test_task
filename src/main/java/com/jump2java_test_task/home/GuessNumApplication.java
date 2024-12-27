package com.jump2java_test_task.home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GuessNumApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GuessNumApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 240);
        stage.setTitle("Игра " + Constants.GAME_NAME + ".");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}