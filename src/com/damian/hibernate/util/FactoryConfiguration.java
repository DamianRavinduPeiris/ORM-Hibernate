package com.damian.hibernate.util;

import com.damian.hibernate.entity.Customer;
import com.damian.hibernate.entity.Item;
import com.damian.hibernate.entity.Orders;
import com.damian.hibernate.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    public  static SessionFactory sessionFactory;
   private  static FactoryConfiguration factoryConfiguration;
    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class).addAnnotatedClass(Orders.class).addAnnotatedClass(OrderDetail.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
       return factoryConfiguration==null?factoryConfiguration=new FactoryConfiguration():factoryConfiguration;
    }
    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
