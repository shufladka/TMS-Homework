package org.tms.service;

import org.tms.entity.TaskEntity;
import org.tms.entity.TaskStatus;
import org.tms.entity.UserEntity;

import java.util.UUID;

public interface TaskService {
    TaskEntity create(String header, String description, TaskStatus taskStatus, UserEntity userEntity);
    void getTaskByTaskId(UUID uuid);
    void refreshStatus(TaskEntity taskEntity, TaskStatus taskStatus);
    void delete(TaskEntity taskEntity);
}