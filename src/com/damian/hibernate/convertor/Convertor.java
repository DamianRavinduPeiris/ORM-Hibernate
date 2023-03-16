package com.damian.hibernate.convertor;

import com.damian.hibernate.dto.Customer_DTO;
import com.damian.hibernate.dto.Item_DTO;
import com.damian.hibernate.dto.OrderDetail_DTO;
import com.damian.hibernate.dto.Order_DTO;
import com.damian.hibernate.entity.Customer;
import com.damian.hibernate.entity.Item;
import com.damian.hibernate.entity.OrderDetail;
import com.damian.hibernate.entity.Orders;

import java.util.ArrayList;
import java.util.List;

public class Convertor {

    public static Customer_DTO convertCustomerEntityToDTO(Customer customer) {
        return new Customer_DTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
    }

    public static Customer convertCustomerDTOToEntity(Customer_DTO customer_dto) {
        return new Customer(customer_dto.getId(), customer_dto.getName(), customer_dto.getAddress(), customer_dto.getSalary());
    }

    public static Item_DTO convertItemEntityToDTO(Item item) {
        return new Item_DTO(item.getItemCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }

    public static Item convertItemDTOToEntity(Item_DTO item_dto) {
        return new Item(item_dto.getItemCode(), item_dto.getDescription(), item_dto.getUnitPrice(), item_dto.getQtyOnHand(),item_dto.getOrdersList());
    }

    public static Order_DTO convertOrderEntityToDTO(Orders order) {
        return new Order_DTO(order.getOId(), order.getDate(), order.getCustomer());
    }

    public static Orders convertOrderDTOToEntity(Order_DTO order_dto) {
        return new Orders(order_dto.getOId(), order_dto.getDate(), order_dto.getCustomer(),order_dto.getItemsList());
    }

    public static OrderDetail_DTO convertOrderDetailEntityToDTO(OrderDetail orderDetail) {
        return new OrderDetail_DTO(orderDetail.getOrderId(), orderDetail.getItemCode(), orderDetail.getQty(), orderDetail.getUnitPrice());
    }

    public static OrderDetail convertOrderDetailDTOToEntity(OrderDetail_DTO orderDetail_dto) {
        return new OrderDetail(orderDetail_dto.getOrderId(), orderDetail_dto.getItemCode(), orderDetail_dto.getQty(), orderDetail_dto.getUnitPrice());
    }

    //method to convert customer to customer_dto list


    //method to convert item to item_dto list
    public static List<Item_DTO> toItemDTOList(List<Item> itemList) {
        List<Item_DTO> item_dtoList = new ArrayList<>();
        for (Item i : itemList) {
            item_dtoList.add(convertItemEntityToDTO(i));
        }
        return item_dtoList;
    }

    //method to convert order to order_dto list
    public static List<Order_DTO> toOrderDTOList(List<Orders> orderList) {
        List<Order_DTO> order_dtoList = new ArrayList<>();
        for (Orders o : orderList) {
            order_dtoList.add(convertOrderEntityToDTO(o));
        }
        return order_dtoList;
    }

    public static List<Customer_DTO> toCustomerDTOList(List<Customer> customerList) {
        List<Customer_DTO> customer_dtoList = new ArrayList<>();
        for (Customer c : customerList) {
            customer_dtoList.add(convertCustomerEntityToDTO(c));
        }
        return customer_dtoList;

    }

}
