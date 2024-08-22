// src/main/java/com/Eamazon/Stock/application/dto/CategoryDTO.java
package com.Eamazon.Stock.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CategoryResponsetDTO {
    private Integer id;
    private String name;
    private String description;
}