package com.damian.hibernate.dao.impl;

import com.damian.hibernate.dao.custom.OrderDAO;
import com.damian.hibernate.entity.Orders;
import com.damian.hibernate.repositories.OrderRepo;

import java.util.List;

public class OrderDAOimpl implements OrderDAO{
    @Override
    public boolean add(Orders order) {
        OrderRepo orderRepo = new OrderRepo();
        return orderRepo.add(order);
    }

    @Override
    public Orders search(String id) {
        return null;
    }

    @Override
    public boolean update(Orders order) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Orders> getAll() {
        return null;
    }
}
