package com.damian.hibernate.repositories;

import com.damian.hibernate.entity.Orders;
import com.damian.hibernate.util.FactoryConfiguration;
import javafx.scene.control.Alert;
import org.hibernate.Session;

public class OrderRepo {
    private final Session session;

    public OrderRepo() {
        session = FactoryConfiguration.getInstance().getSession();
    }

    public boolean add(Orders order) {
        session.beginTransaction();
        try {
            session.save(order);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            Alert a = new Alert(Alert.AlertType.ERROR, "Error in OrderRepo : " + e.getLocalizedMessage());
            a.show();
        } finally {
            session.close();
        }
        return false;
    }
}
