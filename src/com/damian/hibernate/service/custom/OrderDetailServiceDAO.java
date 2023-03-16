package com.damian.hibernate.service.custom;

import com.damian.hibernate.dto.OrderDetail_DTO;
import com.damian.hibernate.dto.Order_DTO;
import com.damian.hibernate.entity.OrderDetail;
import com.damian.hibernate.service.util.SuperService;

import java.util.List;

public interface OrderDetailServiceDAO extends SuperService {

    boolean add(OrderDetail_DTO orderDetail);
    boolean update(OrderDetail_DTO orderDetail);
    boolean delete(String id);
    List<OrderDetail_DTO> getAll();
    OrderDetail_DTO search(String id);
}
