package com.damian.hibernate.controller;

import com.damian.hibernate.dto.Item_DTO;
import com.damian.hibernate.entity.Item;
import com.damian.hibernate.service.impl.ItemServiceimpl;
import com.damian.hibernate.service.util.ServiceFactory;
import com.damian.hibernate.service.util.ServiceTypes;
import com.damian.hibernate.util.NavigationTypes;
import com.damian.hibernate.util.Navigator;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemScreenController {
    public JFXTextField t1;
    public JFXTextField t2;
    public JFXTextField t3;
    public JFXTextField t4;

    public void addOnAction(ActionEvent actionEvent) {
        ItemServiceimpl service = (ItemServiceimpl) ServiceFactory.getService(ServiceTypes.ITEM);
        boolean b = service.add(new Item_DTO(t1.getText(), t2.getText(), Double.valueOf(t3.getText()), Integer.valueOf(t4.getText())));
        if(b){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Item successfully added!");
            a.show();
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR, "Item not added!");
            a.show();
        }

    }

    public void t1OnAction(ActionEvent actionEvent) {
        ItemServiceimpl service = (ItemServiceimpl) ServiceFactory.getService(ServiceTypes.ITEM);
        Item_DTO item = service.search(t1.getText());
        if(item!=null){
            t2.setText(item.getDescription());
            t3.setText(String.valueOf(item.getUnitPrice()));
            t4.setText(String.valueOf(item.getQtyOnHand()));
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR, "No results returned!");
            a.show();
        }

    }

    public void updateOnAction(ActionEvent actionEvent) {
        ItemServiceimpl service = (ItemServiceimpl) ServiceFactory.getService(ServiceTypes.ITEM);
        boolean b = service.update(new Item_DTO(t1.getText(), t2.getText(), Double.valueOf(t3.getText()), Integer.valueOf(t4.getText())));
        if(b){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Item successfully updated!");
            a.show();
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR, "Item not updated!");
            a.show();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        ItemServiceimpl service = (ItemServiceimpl) ServiceFactory.getService(ServiceTypes.ITEM);
        boolean b = service.delete(t1.getText());
        if(b){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Item successfully deleted!");
            a.show();
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR, "Item not deleted!");
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
        Navigator.navigate(NavigationTypes.HOME,stage);
    }
}
