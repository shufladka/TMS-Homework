package org.tms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="film")
public class FilmEntity {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(length = 1024)
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Temporal(TemporalType.DATE)
    private Date dateOfIssue;

    private Double rating;
}