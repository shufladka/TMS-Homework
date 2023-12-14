package org.tms.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tms.entity.TaskEntity;
import org.tms.entity.UserEntity;


public class HibernateConfig {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .addAnnotatedClass(UserEntity.class)
                .addAnnotatedClass(TaskEntity.class)
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "postgres")
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect")
                .setProperty("hibernate.show.sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "create-drop")
//                .setProperty("hibernate.hbm2ddl.auto", "update")
//                .setProperty("hibernate.hbm2ddl.auto", "none")
                .buildSessionFactory();
    }

    public static Session create(){
        return sessionFactory.openSession();
    }
}