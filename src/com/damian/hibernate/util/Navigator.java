package com.damian.hibernate.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {
    public static Stage stage;
    public static void navigate(NavigationTypes nt, Stage currentStage) throws IOException {
        stage = currentStage;
        switch (nt){
            case HOME:
                changeUI("HomeScreen.fxml");
                break;
            case CUSTOMERS:
                changeUI("CustomerScreen.fxml");
                break;
            case ITEMS:
                changeUI("ItemScreen.fxml");
                break;
            case ORDERS:
                changeUI("PlaceOrderForm.fxml");
                break;
            default:Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Cannot load UI!");
                a.show();
        }

    }
    public static void changeUI(String path) throws IOException {
        stage.close();
      stage.setScene(new Scene(FXMLLoader.load(Navigator.class.getResource("/com/damian/hibernate/view/"+path))));
      stage.show();
    }
}
