package org.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tms.domain.Genre;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmCreateDto {
    private String name;
    private Genre genre;
    private Date dateOfIssue;
    private Double rating;
}
