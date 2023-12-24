package org.tms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="films")
@NamedQuery(name = "FilmEntity.updateRating", query = "update FilmEntity set rating =: rating where id =: id")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 1024, name = "film")
    private String name;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "date_of_issue")
    @Temporal(TemporalType.DATE)
    private Date dateOfIssue;

    @Column(name = "rating")
    private Integer rating;
}