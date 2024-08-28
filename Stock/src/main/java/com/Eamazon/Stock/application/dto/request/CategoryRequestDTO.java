// src/main/java/com/Eamazon/Stock/application/dto/CategoryDTO.java
package com.Eamazon.Stock.application.dto.request;


public class CategoryRequestDTO {
    private String name;
    private String description;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}