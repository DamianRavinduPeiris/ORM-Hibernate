package com.damian.hibernate.service.custom;

import com.damian.hibernate.dto.Order_DTO;
import com.damian.hibernate.service.util.SuperService;

import java.util.List;

public interface OrderServiceDAO extends SuperService {

    boolean add(Order_DTO orderDetail);
    boolean update(Order_DTO orderDetail);
    boolean delete(String id);
    List<Order_DTO> getAll();
    Order_DTO search(String id);
}
