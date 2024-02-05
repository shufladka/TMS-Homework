package org.tms.domain;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private ContentType contentType;
    private Integer amount;
    private Double price;
}