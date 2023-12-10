package org.tms.service.interfaces;

import org.hibernate.Session;
import org.tms.config.HibernateConfig;

import java.util.UUID;

public interface DAO<T> {

    T getById(UUID uuid);
    void delete(T obj);

    static Session openSessionAndTransaction() {

        Session session = HibernateConfig.create();
        session.getTransaction().begin();

        return session;
    }

    static void closeSessionAndTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
