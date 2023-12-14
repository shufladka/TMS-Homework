package org.tms.service.interfaces;

import org.tms.entity.*;
import org.tms.entity.additions.Sex;
import org.tms.entity.additions.TaskStatus;
import org.tms.entity.additions.UserType;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    UserEntity create(String name, LocalDate dateOfBirth, Sex sex, UserType userType);
    void getUserById(String id);
    void update(UserEntity userEntity, String name, LocalDate dateOfBirth, Sex sex, UserType userType);
    void delete(UserEntity userEntity);
    List<UserEntity> findBusyUsers(TaskStatus taskStatus);
}