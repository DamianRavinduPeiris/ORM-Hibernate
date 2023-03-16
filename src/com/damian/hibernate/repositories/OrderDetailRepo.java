package com.damian.hibernate.repositories;

import com.damian.hibernate.entity.OrderDetail;
import com.damian.hibernate.util.FactoryConfiguration;
import javafx.scene.control.Alert;
import org.hibernate.Session;

public class OrderDetailRepo {
    private final Session session;

    public OrderDetailRepo() {
        session = FactoryConfiguration.getInstance().getSession();
    }

    public boolean add(OrderDetail orderDetail) {
        session.beginTransaction();
        try {
            session.save(orderDetail);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            Alert a = new Alert(Alert.AlertType.ERROR, "Error in OrderDetailRepo : " + e.getLocalizedMessage());
            a.show();
        } finally {
            session.close();
        }

        return false;
    }

}

