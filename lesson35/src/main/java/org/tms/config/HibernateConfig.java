package org.tms.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tms.entity.TaskEntity;
import org.tms.entity.UserEntity;


public class HibernateConfig {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hibernate");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "Frikadel01");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.show.sql", "true");
//        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//        configuration.setProperty("hibernate.hbm2ddl.auto", "none");

        configuration.addAnnotatedClass(UserEntity.class);
        configuration.addAnnotatedClass(TaskEntity.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session create(){
        return sessionFactory.openSession();
    }
}

