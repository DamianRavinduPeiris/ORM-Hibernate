package com.damian.hibernate.service.impl;

import com.damian.hibernate.dto.OrderDetail_DTO;
import com.damian.hibernate.entity.OrderDetail;
import com.damian.hibernate.service.custom.OrderDetailServiceDAO;
import com.damian.hibernate.service.util.SuperService;

import java.util.List;

public class OrderDetailsServiceimpl implements OrderDetailServiceDAO {
    @Override
    public boolean add(OrderDetail_DTO orderDetail) {
        return false;
    }

    @Override
    public boolean update(OrderDetail_DTO orderDetail) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public OrderDetail_DTO search(String id) {
        return null;
    }

    @Override
    public List<OrderDetail_DTO> getAll() {
        return null;
    }
}
