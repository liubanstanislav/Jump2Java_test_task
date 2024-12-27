package com.jump2java_test_task.home;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class GuessNumController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button playBtn;

    @FXML
    private TextArea textArea;

    @FXML
    private Label textOutLabel;

    @FXML
    private Button tryBtn;

    @FXML
    void onHelloButtonClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        System.out.println(getRandomNum());
    }


    private byte getRandomNum() {
        return (byte) (Math.random() * 100);
    }

    private byte getNumFromUser(){
        String userText = textArea.getText();
        return Byte.parseByte(userText);
    }
}
