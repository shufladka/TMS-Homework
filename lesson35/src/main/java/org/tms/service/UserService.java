package org.tms.service;

import org.tms.entity.*;

import java.util.Date;
import java.util.List;

public interface UserService {
    UserEntity create(String name, Date dateOfBirth, Sex sex, UserType userType);
    void getUserById(String id);
    void update(UserEntity userEntity, String name, Date dateOfBirth, Sex sex, UserType userType);
    void delete(UserEntity userEntity);
    List<UserEntity> findBusyUsers(TaskStatus taskStatus);
}