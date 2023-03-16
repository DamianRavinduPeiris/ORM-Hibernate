package com.damian.hibernate.controller;

import animatefx.animation.Bounce;
import animatefx.animation.LightSpeedIn;
import animatefx.animation.Shake;
import com.damian.hibernate.util.NavigationTypes;
import com.damian.hibernate.util.Navigator;
import com.jfoenix.controls.JFXButton;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class HomeScreenController implements Initializable {
    public Label dateAndTime;
    public JFXButton customerBtn;
    public JFXButton ordersBtn;
    public JFXButton itemsBtn;
    public Label mainLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                dateAndTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
        };
        timer.start();
        JFXButton [] buttons = {itemsBtn, ordersBtn, customerBtn};

        for(JFXButton button : buttons){
            new Bounce(button).play();
        }
        new LightSpeedIn(mainLabel).play();
        new Shake(dateAndTime).play();
    }

    public void mcOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) dateAndTime.getScene().getWindow();
        Navigator.navigate(NavigationTypes.CUSTOMERS, stage);
    }

    public void miOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) dateAndTime.getScene().getWindow();
        Navigator.navigate(NavigationTypes.ITEMS, stage);
    }

    public void moOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) dateAndTime.getScene().getWindow();
        Navigator.navigate(NavigationTypes.ORDERS, stage);
    }
}
