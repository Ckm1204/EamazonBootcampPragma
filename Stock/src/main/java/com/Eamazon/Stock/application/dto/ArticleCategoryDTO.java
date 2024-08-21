// src/main/java/com/Eamazon/Stock/application/dto/ArticleCategoryDTO.java
package com.Eamazon.Stock.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleCategoryDTO {
    private Integer id;
    private Integer articleId;
    private Integer categoryId;
}