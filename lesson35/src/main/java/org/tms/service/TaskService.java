package org.tms.service;

import org.tms.entity.TaskEntity;
import org.tms.entity.TaskStatus;
import org.tms.entity.UserEntity;

public interface TaskService {
    TaskEntity create(String header, String description, TaskStatus taskStatus, UserEntity userEntity);
    void getTaskByTaskId(String id);
    void getTaskByUser(UserEntity userEntity);
    void refreshStatus(TaskEntity taskEntity, TaskStatus taskStatus);
    void delete(TaskEntity taskEntity);
}