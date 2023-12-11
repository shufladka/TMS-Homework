package org.tms.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID taskId;

    @Column(length = 1024)
    private String header;

    @Column(length = 1024)
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "userId")
    private UserEntity userEntity;
}