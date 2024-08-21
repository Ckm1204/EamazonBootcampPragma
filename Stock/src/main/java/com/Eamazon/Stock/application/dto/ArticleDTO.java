// src/main/java/com/Eamazon/Stock/application/dto/ArticleDTO.java
package com.Eamazon.Stock.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
}