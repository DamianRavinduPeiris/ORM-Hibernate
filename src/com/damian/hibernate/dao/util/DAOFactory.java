package com.damian.hibernate.dao.util;

import com.damian.hibernate.dao.impl.CustomerDAOimpl;
import com.damian.hibernate.dao.impl.ItemDAOimpl;
import com.damian.hibernate.dao.impl.OrderDAOimpl;
import com.damian.hibernate.dao.impl.OrderDetailDAOimpl;

public class DAOFactory {
    public static SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOimpl();
            case ITEM:
                return new ItemDAOimpl();
            case ORDER:
                return new OrderDAOimpl();
            case ORDERDETAILS:
               return new OrderDetailDAOimpl();
            default:
                return null;
        }

    }
}
