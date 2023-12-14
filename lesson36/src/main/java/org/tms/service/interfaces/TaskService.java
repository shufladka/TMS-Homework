package org.tms.service.interfaces;

import org.tms.entity.TaskEntity;
import org.tms.entity.additions.TaskStatus;
import org.tms.entity.UserEntity;

import java.util.UUID;

public interface TaskService {
    TaskEntity create(String header, String description, TaskStatus taskStatus, UserEntity userEntity);
    void getTaskByTaskId(UUID uuid);
    void refreshStatus(UUID taskID, TaskStatus taskStatus);
    void delete(TaskEntity taskEntity);
}