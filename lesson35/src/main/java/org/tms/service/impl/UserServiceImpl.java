package org.tms.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tms.config.HibernateConfig;
import org.tms.entity.*;
import org.tms.service.UserService;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public UserEntity create(String name, Date dateOfBirth, Sex sex, UserType userType) {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        UserEntity userEntity = UserEntity.builder()
                .name(name)
                .dateOfBirth(dateOfBirth)
                .sex(sex)
                .userType(userType)
                .build();

        session.save(userEntity);

        transaction.commit();
        session.close();

        return userEntity;
    }

    @Override
    public void getUserById(String id) {
        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        UserEntity userEntity = session.find(UserEntity.class, UUID.fromString(id));
        System.out.println(userEntity);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(UserEntity userEntity, String name, Date dateOfBirth, Sex sex, UserType userType) {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("update UserEntity as ue set ue.name =: nameUpdated, ue.dateOfBirth =: dateUpdated, ue.sex =: sexUpdated, ue.userType =: typeUpdated where ue.userId =: userEntity_uuid");
        query.setParameter("nameUpdated", name);
        query.setParameter("dateUpdated", dateOfBirth);
        query.setParameter("sexUpdated", sex);
        query.setParameter("typeUpdated", userType);
        query.setParameter("userEntity_uuid", userEntity.getUserId());
        query.executeUpdate();

        userEntity.setName(name);
        userEntity.setDateOfBirth(dateOfBirth);
        userEntity.setSex(sex);
        userEntity.setUserType(userType);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(UserEntity userEntity) {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        session.delete(userEntity);

        transaction.commit();
        session.close();
    }

    @Override
    public List<UserEntity> findBusyUsers(TaskStatus taskStatus) {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("select ue from UserEntity as ue join ue.tasks as tsks where tsks.taskStatus =: activeStatus");
        query.setParameter("activeStatus", taskStatus);
        List resultList = query.getResultList();

        transaction.commit();
        session.close();

        return resultList;
    }
}
