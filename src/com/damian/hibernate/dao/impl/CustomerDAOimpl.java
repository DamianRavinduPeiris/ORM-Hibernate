package com.damian.hibernate.dao.impl;

import com.damian.hibernate.dao.custom.CustomerDAO;
import com.damian.hibernate.entity.Customer;
import com.damian.hibernate.repositories.CustomerRepo;

import java.util.List;

public class CustomerDAOimpl implements CustomerDAO {
    @Override
    public boolean add(Customer customer) {
        CustomerRepo repo = new CustomerRepo();
        return repo.add(customer);
    }

    @Override
    public Customer search(String id) {
        CustomerRepo repo = new CustomerRepo();
       return repo.findById(id);
    }

    @Override
    public boolean update(Customer customer) {
        CustomerRepo repo = new CustomerRepo();

        return repo.update(customer);
    }

    @Override
    public boolean delete(String id) {
        CustomerRepo repo = new CustomerRepo();
        return repo.delete(id);
    }

    @Override
    public List<Customer> getAll() {
        CustomerRepo repo = new CustomerRepo();
        return repo.getAll();
    }
}
