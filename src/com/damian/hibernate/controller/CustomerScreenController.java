package com.damian.hibernate.controller;

import com.damian.hibernate.dto.Customer_DTO;
import com.damian.hibernate.entity.Customer;
import com.damian.hibernate.service.impl.CustomerServiceimpl;
import com.damian.hibernate.service.util.ServiceFactory;
import com.damian.hibernate.service.util.ServiceTypes;
import com.damian.hibernate.service.util.SuperService;
import com.damian.hibernate.util.NavigationTypes;
import com.damian.hibernate.util.Navigator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerScreenController {
    public JFXTextField t1;
    public JFXTextField t2;
    public JFXTextField t3;
    public JFXTextField t4;
    public JFXButton backButton;

    public void t1OnAction(ActionEvent actionEvent) {
        CustomerServiceimpl service = (CustomerServiceimpl) ServiceFactory.getService(ServiceTypes.CUSTOMER);
        Customer_DTO c1 = service.getCustomer(t1.getText());
        if (c1 != null) {
            t2.setText(c1.getName());
            t3.setText(c1.getAddress());
            t4.setText(String.valueOf(c1.getSalary()));
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "No result returned!");
            a.show();
        }
    }

    public void addOnAction(ActionEvent actionEvent) {
        Customer_DTO c1 = new Customer_DTO(t1.getText(), t2.getText(), t3.getText(), Double.valueOf(t4.getText()));
        CustomerServiceimpl cus = (CustomerServiceimpl) ServiceFactory.getService(ServiceTypes.CUSTOMER);
        boolean b = cus.add(c1);
        if (b) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Customer added successfully!");
            a.show();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "An error occurred!");
            a.show();
        }

    }

    public void updateOnAction(ActionEvent actionEvent) {
        Customer_DTO c1 = new Customer_DTO(t1.getText(), t2.getText(), t3.getText(), Double.valueOf(t4.getText()));
        CustomerServiceimpl cus = (CustomerServiceimpl) ServiceFactory.getService(ServiceTypes.CUSTOMER);
        boolean b = cus.update(c1);
        if (b) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Customer updated successfully!");
            a.show();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "An error occurred!");
            a.show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        CustomerServiceimpl service = (CustomerServiceimpl) ServiceFactory.getService(ServiceTypes.CUSTOMER);
        boolean delete = service.deleteCustomer(t1.getText());
        if (delete) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Customer deleted successfully!");
            a.show();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "An error occurred!");
            a.show();
        }
    }

    public void clearOnAction(ActionEvent actionEvent) {
        TextField[] textFields = {t1, t2, t3, t4};
        for (TextField textField : textFields) {
            textField.clear();
        }
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) t1.getScene().getWindow();
        Navigator.navigate(NavigationTypes.HOME, stage);

    }
}


