package org.tms.service.interfaces;

import org.tms.entity.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface UserService {
    UserEntity create(String name, LocalDate dateOfBirth, Sex sex, UserType userType);
    void getUserById(String id);
    void update(UserEntity userEntity, String name, LocalDate dateOfBirth, Sex sex, UserType userType);
    void delete(UserEntity userEntity);
    List<UserEntity> findBusyUsers(TaskStatus taskStatus);
}