// src/main/java/com/Eamazon/Stock/application/dto/CategoryDTO.java
package com.Eamazon.Stock.application.dto.response;


public class CategoryResponsetDTO {
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}