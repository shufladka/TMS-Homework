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
@Table(name="films")
@NamedQuery(name = "FilmEntity.updateRating", query = "update FilmEntity set rating =: rating where id =: id")
public class FilmEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 1024)
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Temporal(TemporalType.DATE)
    private Date dateOfIssue;

    private Integer rating;
}