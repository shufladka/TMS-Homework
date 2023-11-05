package org.tms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID userId;

    @Column(length = 1024)
    private String name;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @OneToMany(mappedBy = "userEntity", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<TaskEntity> tasks;

    // пополнение списка заданий пользователя
    public void addNewTask(TaskEntity task) {

        if (tasks == null || tasks.isEmpty()) {
            tasks = new ArrayList<>();
        }

        task.setUserEntity(this);
        tasks.add(task);
    }
}