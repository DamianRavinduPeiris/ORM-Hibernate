package com.damian.hibernate.service.impl;

import com.damian.hibernate.controller.PlaceOrderFormController;
import com.damian.hibernate.convertor.Convertor;
import com.damian.hibernate.dao.custom.OrderDetailDAO;
import com.damian.hibernate.dao.impl.OrderDAOimpl;
import com.damian.hibernate.dao.impl.OrderDetailDAOimpl;
import com.damian.hibernate.dao.util.DAOFactory;
import com.damian.hibernate.dao.util.DAOTypes;
import com.damian.hibernate.dto.Item_DTO;
import com.damian.hibernate.dto.OrderDetail_DTO;
import com.damian.hibernate.dto.Order_DTO;
import com.damian.hibernate.entity.Item;
import com.damian.hibernate.entity.OrderDetail;
import com.damian.hibernate.entity.Orders;
import com.damian.hibernate.service.custom.OrderDetailServiceDAO;
import com.damian.hibernate.service.custom.OrderServiceDAO;
import com.damian.hibernate.service.util.ServiceFactory;
import com.damian.hibernate.service.util.ServiceTypes;
import com.damian.hibernate.service.util.SuperService;
import com.damian.hibernate.util.FactoryConfiguration;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceimpl implements OrderServiceDAO {
    private OrderDetail_DTO orderDetailDTO;


    @Override
    public boolean add(Order_DTO order) {
        boolean b3 = false;
        OrderDAOimpl dao = (OrderDAOimpl) DAOFactory.getDAO(DAOTypes.ORDER);//Saving the Order.
        boolean b1 = dao.add(Convertor.convertOrderDTOToEntity(order));
        if (b1) {
                List<OrderDetail_DTO> orderDetails1 = PlaceOrderFormController.getOrderDetails();
                for(OrderDetail_DTO od : orderDetails1) {
                    System.out.println("Item code : "+od.getItemCode());
                     b3 = updateItem(od.getItemCode(), od);//Updating the QtyOnHand on ItemObject.
            }
                return b3;

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Error While Adding Order!");
            a.show();
        }
        return false;
    }

    public boolean updateItem(String itemCode, OrderDetail_DTO orderDetailDTO) {
        ItemServiceimpl itemServiceimpl = (ItemServiceimpl) ServiceFactory.getService(ServiceTypes.ITEM);
        Item_DTO item = itemServiceimpl.search(itemCode);
        item.setOrdersList(PlaceOrderFormController.getOrdersList());
        item.setQtyOnHand(item.getQtyOnHand() - orderDetailDTO.getQty());//Updating the QtyOnHand on ItemObject.
        return itemServiceimpl.update(item);
    }

    @Override
    public boolean update(Order_DTO orderDetail) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Order_DTO search(String id) {
        return null;
    }

    @Override
    public List<Order_DTO> getAll() {
        return null;
    }

    public void setValues(OrderDetail_DTO orderDetailDTO) {
        this.orderDetailDTO = orderDetailDTO;
    }
}
