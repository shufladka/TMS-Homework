package domain;

import lombok.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private UUID id;
    private String title;
    private String description;
    private Integer pages;
    private String author;
}