package com.damian.hibernate.service.util;

import com.damian.hibernate.service.impl.CustomerServiceimpl;
import com.damian.hibernate.service.impl.ItemServiceimpl;
import com.damian.hibernate.service.impl.OrderDetailsServiceimpl;
import com.damian.hibernate.service.impl.OrderServiceimpl;

public class ServiceFactory {
    public static SuperService getService(ServiceTypes serviceType) {
        switch (serviceType) {
        case CUSTOMER:
            return new CustomerServiceimpl();
        case ORDER:
            return new OrderServiceimpl();
        case ORDERDETAILS:
            return new OrderDetailsServiceimpl();
        case ITEM:
            return new ItemServiceimpl();
        default:
            return null;
        }
    }
}
