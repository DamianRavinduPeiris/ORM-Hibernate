package com.damian.hibernate.dao.impl;

import com.damian.hibernate.dao.custom.OrderDetailDAO;
import com.damian.hibernate.entity.OrderDetail;
import com.damian.hibernate.repositories.OrderDetailRepo;

import java.util.List;

public class OrderDetailDAOimpl implements OrderDetailDAO {


    @Override
    public boolean add(OrderDetail orderDetail) {
        OrderDetailRepo orderDetailRepo = new OrderDetailRepo();
        return orderDetailRepo.add(orderDetail);
    }

    @Override
    public OrderDetail search(String id) {
        return null;
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<OrderDetail> getAll() {
        return null;
    }
}
