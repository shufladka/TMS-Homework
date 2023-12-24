package org.tms.dto;

import com.fasterxml.jackson.databind.DatabindException;
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
public class FilmSearchDto {
    private String name;
    private Genre genre;
    private Date dateOfIssue;
    private Integer rating;
    private Integer from;
    private Integer to;
}