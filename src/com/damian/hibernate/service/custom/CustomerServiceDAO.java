package com.damian.hibernate.service.custom;

import com.damian.hibernate.dto.Customer_DTO;
import com.damian.hibernate.entity.Customer;
import com.damian.hibernate.service.util.SuperService;

import java.util.List;

public interface CustomerServiceDAO extends SuperService{
    boolean add(Customer_DTO customer);
    Customer_DTO getCustomer(String id);
    List<Customer_DTO> getAllCustomers();
    boolean update(Customer_DTO customer);



    boolean deleteCustomer(String id);
}
