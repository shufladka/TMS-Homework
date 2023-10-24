package org.tms.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "phones")
public class PhoneEntity {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(length = 1024)
    private String number;

    private Boolean isBlocked;

    @Temporal(TemporalType.DATE)
    private Date dateOfActivate;

    @Enumerated(EnumType.STRING)
    private Operator operator;

    @ToString.Exclude
    @ManyToOne
    private PersonEntity persons;
}