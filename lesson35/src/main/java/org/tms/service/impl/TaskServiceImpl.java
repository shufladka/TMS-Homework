package org.tms.service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tms.config.HibernateConfig;
import org.tms.entity.TaskEntity;
import org.tms.entity.TaskStatus;
import org.tms.entity.UserEntity;
import org.tms.service.TaskService;

import javax.persistence.Query;
import java.util.UUID;

public class TaskServiceImpl implements TaskService {

    @Override
    public TaskEntity create(String header, String description, TaskStatus taskStatus, UserEntity userEntity) {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        TaskEntity taskEntity = TaskEntity.builder()
                .header(header)
                .description(description)
                .taskStatus(taskStatus)
                .userEntity(userEntity)
                .build();

        session.save(taskEntity);

        transaction.commit();
        session.close();

        return taskEntity;
    }

    @Override
    public void getTaskByTaskId(String id) {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        TaskEntity taskEntity = session.find(TaskEntity.class, UUID.fromString(id));
        System.out.println(taskEntity);

        transaction.commit();
        session.close();
    }

    @Override
    public void getTaskByUser(UserEntity userEntity) {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        TaskEntity taskEntity = session.find(TaskEntity.class, userEntity.getUserId());
        System.out.println(taskEntity);

        transaction.commit();
        session.close();
    }

    @Override
    public void refreshStatus(TaskEntity taskEntity, TaskStatus taskStatus) {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("update TaskEntity as te set te.taskStatus =: statusUpdated where te.id =: taskEntity_uuid");
        query.setParameter("statusUpdated", taskStatus);
        query.setParameter("taskEntity_uuid", taskEntity.getTaskId());
        query.executeUpdate();

        taskEntity.setTaskStatus(taskStatus);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(TaskEntity taskEntity) {

        Session session = HibernateConfig.create();
        Transaction transaction = session.beginTransaction();

        session.delete(taskEntity);

        transaction.commit();
        session.close();
    }
}