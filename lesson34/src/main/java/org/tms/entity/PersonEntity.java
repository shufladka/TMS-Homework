package org.tms.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(length = 1024)
    private String firstName;

    @Column(length = 1024)
    private String lastName;

    private Boolean isMarried;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "persons")
    private List<PhoneEntity> phones;
}