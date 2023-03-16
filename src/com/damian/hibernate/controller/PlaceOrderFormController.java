package com.damian.hibernate.controller;

import animatefx.animation.Bounce;
import animatefx.animation.LightSpeedIn;
import animatefx.animation.Shake;
import com.damian.hibernate.convertor.Convertor;
import com.damian.hibernate.dto.Customer_DTO;
import com.damian.hibernate.dto.Item_DTO;
import com.damian.hibernate.dto.OrderDetail_DTO;
import com.damian.hibernate.dto.Order_DTO;
import com.damian.hibernate.entity.Item;
import com.damian.hibernate.entity.Orders;
import com.damian.hibernate.model.TableModel;
import com.damian.hibernate.service.impl.CustomerServiceimpl;
import com.damian.hibernate.service.impl.ItemServiceimpl;
import com.damian.hibernate.service.impl.OrderServiceimpl;
import com.damian.hibernate.service.util.ServiceFactory;
import com.damian.hibernate.service.util.ServiceTypes;
import com.damian.hibernate.util.NavigationTypes;
import com.damian.hibernate.util.Navigator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {
    private static final ObservableList<TableModel> tableModels = FXCollections.observableArrayList();
    static ArrayList<Orders> ordersList = new ArrayList<>();
    private static Customer_DTO customerDto;
    public Label itemPriceLabel;
    public JFXButton atcButton;
    public JFXComboBox<String> cidCmb;
    public JFXComboBox<String> itemCodeCmb;
    public TableView<TableModel> tableView;
    public TableColumn c1;
    public TableColumn c2;
    public TableColumn c3;
    public TableColumn c4;
    public TableColumn c5;
    public JFXButton placeOrderButton;
    public Label netTotalLabel;
    public Label ItemNameLabel;
    public Label qtyOnHandLabel;
    public TextField qtyField;
    public Label nameLabel;
    public Label priceLabel;
    public JFXButton clear;
    public Label mainLabel;
    public Label oidLabel1;
    private Item_DTO itemDto;
    private final ArrayList<Orders> ordersArrayList = new ArrayList<>();

    public static List<OrderDetail_DTO> getOrderDetails() {
        ArrayList<OrderDetail_DTO> orderDetailDtos = new ArrayList<>();
        for (int i = 0; i < tableModels.size(); i++) {
            orderDetailDtos.add(new OrderDetail_DTO(tableModels.get(i).getOID(), tableModels.get(i).getItemCode(), tableModels.get(i).getQty(), tableModels.get(i).getUnitPrice()));
        }
        return orderDetailDtos;

    }

    public static String getItemCode(String oid) {
        for (int i = 0; i < tableModels.size(); i++) {
            if (tableModels.get(i).getOID().equals(oid)) {
                return tableModels.get(i).getItemCode();
            }
        }
        return null;

    }

    public static List<Orders> getOrdersList() {
        return ordersList;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        c1.setCellValueFactory(new PropertyValueFactory<>("oID"));
        c2.setCellValueFactory(new PropertyValueFactory<>("description"));
        c3.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        c4.setCellValueFactory(new PropertyValueFactory<>("qty"));
        c5.setCellValueFactory(new PropertyValueFactory<>("itemCode"));

        CustomerServiceimpl cs1 = (CustomerServiceimpl) ServiceFactory.getService(ServiceTypes.CUSTOMER);
        List<Customer_DTO> customerDtoList = cs1.getAllCustomers();

        ObservableList<String> customerIds = FXCollections.observableArrayList();
        for (Customer_DTO c : customerDtoList) {
            customerIds.add(c.getId());
        }
        cidCmb.setItems(customerIds);

        ItemServiceimpl service = (ItemServiceimpl) ServiceFactory.getService(ServiceTypes.ITEM);
        List<Item_DTO> itemDtoList = service.getAll();
        ObservableList<String> itemCodes = FXCollections.observableArrayList();

        for (Item_DTO id : itemDtoList) {
            System.out.println(id.getItemCode());
            itemCodes.add(id.getItemCode());
        }
        itemCodeCmb.setItems(itemCodes);


        Random random = new Random();
        int x = random.nextInt(1000);
        String oid = "OD" + x;
        oidLabel1.setText(oid);


        new LightSpeedIn(mainLabel).play();
        new Shake(tableView).play();
        new Bounce(atcButton).play();
        new Bounce(placeOrderButton).play();
    }

    public void atcButtonOnAction(ActionEvent actionEvent) throws InterruptedException {
        String qty = qtyField.getText();

        TableModel tm = new TableModel(oidLabel1.getText(), ItemNameLabel.getText(), Double.valueOf(priceLabel.getText()), Integer.valueOf(qtyField.getText()), itemCodeCmb.getValue());
        if (qtyField.getText().isEmpty() || qtyField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Fields cannot be empty!");
            alert.show();
        }
        if (qty.matches(".*[a-zA-Z]+.*")) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setContentText("Quantity cannot be a string!");
            alert1.show();

        } else {
            tableModels.add(tm);
            tableView.setItems(tableModels);
            new Shake(tableView).play();

        }
        double total = 0;

        for (int i = 0; i < tableModels.size(); i++) {
            total += tableModels.get(i).getUnitPrice() * tableModels.get(i).getQty();
        }
        netTotalLabel.setText(String.valueOf(total));
        new Shake(netTotalLabel).play();
    }

    public void cidCmbOnAction(ActionEvent actionEvent) {
        CustomerServiceimpl service = (CustomerServiceimpl) ServiceFactory.getService(ServiceTypes.CUSTOMER);
        Customer_DTO customer = service.getCustomer(cidCmb.getValue());
        nameLabel.setText(customer.getName());

    }

    public void itemCodeCmbOnAction(ActionEvent actionEvent) {
        ItemServiceimpl service = (ItemServiceimpl) ServiceFactory.getService(ServiceTypes.ITEM);
        Item_DTO item = service.search(itemCodeCmb.getValue());
        ItemNameLabel.setText(item.getDescription());
        priceLabel.setText(String.valueOf(item.getUnitPrice()));
        qtyOnHandLabel.setText(String.valueOf(item.getQtyOnHand()));
    }

    public void tableViewOnAction(MouseEvent mouseEvent) {
    }

    public void placeOrderButtonOnAction(ActionEvent actionEvent) {
        CustomerServiceimpl cs = (CustomerServiceimpl) ServiceFactory.getService(ServiceTypes.CUSTOMER);

        customerDto = cs.getCustomer(cidCmb.getValue());
        OrderServiceimpl os = (OrderServiceimpl) ServiceFactory.getService(ServiceTypes.ORDER);


        ArrayList<Item> itemsList = new ArrayList<>();


        for (int i = 0; i < tableModels.size(); i++) {
            String itemCode = tableModels.get(i).getItemCode();
            ItemServiceimpl itemService = (ItemServiceimpl) ServiceFactory.getService(ServiceTypes.ITEM);
            itemDto = itemService.search(itemCode); //Getting items from table for the order object.
            itemsList.add(Convertor.convertItemDTOToEntity(itemDto)); //
        }
        Order_DTO order = new Order_DTO(oidLabel1.getText(), Date.valueOf(LocalDate.now()), Convertor.convertCustomerDTOToEntity(customerDto));
        order.setItemsList(itemsList); //Adding itemList to the order.
       /* ordersArrayList.add(Convertor.convertOrderDTOToEntity(order)); //Adding order to the orderList for the Item object.
        itemDto.setOrdersList(ordersArrayList);*/


        /*ordersArrayList.add(Convertor.convertOrderDTOToEntity(order));//Adding order to the orderList for the Item object.*/

        boolean b = os.add(order);

        if (b) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Order Placed Successfully!");
            alert.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Order placing Failed!");
            alert.show();
        }


    }
/*    public void setOrderLists(){
        ItemServiceimpl is = (ItemServiceimpl) ServiceFactory.getService(ServiceTypes.ITEM);
        boolean b = false;
        for(int i=0;i<tableModels.size();i++){
            Item_DTO item = is.search(tableModels.get(i).getItemCode());
            item.setOrdersList(ordersArrayList);
            b = is.update(item);
        }
        if(b) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Order List Updated Successfully!");
            alert.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Order List Updating Failed!");
            alert.show();
        }
    }*/

    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) itemCodeCmb.getScene().getWindow();
        Navigator.navigate(NavigationTypes.HOME, stage);
    }

    public void clearButtonOnAction(ActionEvent actionEvent) throws IOException {
        Navigator.navigate(NavigationTypes.ORDERS, (Stage) clear.getScene().getWindow());
    }
}
