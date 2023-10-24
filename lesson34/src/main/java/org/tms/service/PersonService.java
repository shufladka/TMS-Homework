package org.tms.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tms.config.HibernateConfig;
import org.tms.entity.PersonEntity;

import java.util.UUID;

public class PersonService {

    public UUID savePerson(PersonEntity personEntity) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        UUID saved = (UUID) session.save(personEntity);

        transaction.commit();
        session.close();

        return saved;
    }

    public PersonEntity getPerson(UUID id) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        PersonEntity found = session.find(PersonEntity.class, id);
        System.out.println(found);

        transaction.commit();
        session.close();

        return found;
    }
}