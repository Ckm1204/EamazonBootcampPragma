// src/main/java/com/Eamazon/Stock/application/dto/CategoryDTO.java
package com.Eamazon.Stock.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CategoryRequestDTO {
    private Integer id;
    private String name;
    private String description;
}