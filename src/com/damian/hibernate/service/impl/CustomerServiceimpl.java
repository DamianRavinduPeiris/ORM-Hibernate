package com.damian.hibernate.service.impl;

import com.damian.hibernate.convertor.Convertor;
import com.damian.hibernate.dao.impl.CustomerDAOimpl;
import com.damian.hibernate.dao.util.DAOFactory;
import com.damian.hibernate.dao.util.DAOTypes;
import com.damian.hibernate.dto.Customer_DTO;
import com.damian.hibernate.entity.Customer;
import com.damian.hibernate.service.custom.CustomerServiceDAO;

import java.util.List;

public class CustomerServiceimpl implements CustomerServiceDAO {
    @Override
    public boolean add(Customer_DTO customer) {
        CustomerDAOimpl dao = (CustomerDAOimpl) DAOFactory.getDAO(DAOTypes.CUSTOMER);
        return dao.add(Convertor.convertCustomerDTOToEntity(customer));
    }

    @Override
    public boolean update(Customer_DTO customer) {
        CustomerDAOimpl dao = (CustomerDAOimpl) DAOFactory.getDAO(DAOTypes.CUSTOMER);
        return dao.update(Convertor.convertCustomerDTOToEntity(customer));

    }

    @Override
    public boolean deleteCustomer(String id) {
        CustomerDAOimpl dao = (CustomerDAOimpl) DAOFactory.getDAO(DAOTypes.CUSTOMER);
        return  dao.delete(id);
    }



    @Override
    public Customer_DTO getCustomer(String id) {
        CustomerDAOimpl dao = (CustomerDAOimpl) DAOFactory.getDAO(DAOTypes.CUSTOMER);
        Customer customer = dao.search(id);
        if(customer!=null) {
            return Convertor.convertCustomerEntityToDTO(customer);
        }
        return null;
    }

    @Override
    public List<Customer_DTO> getAllCustomers() {
        CustomerDAOimpl dao = (CustomerDAOimpl) DAOFactory.getDAO(DAOTypes.CUSTOMER);
       return Convertor.toCustomerDTOList(dao.getAll());

    }


}
