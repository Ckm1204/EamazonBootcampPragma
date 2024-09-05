package com.Eamazon.Stock.domain.model.response;

import com.Eamazon.Stock.domain.paginate.Nameable;

public class BrandModelResponse implements Nameable {

    private Integer id;
    private String name;
    private String description;


    public Integer getId() {
        return id;
    }

    public BrandModelResponse() {
        // No-argument constructor
    }
    public BrandModelResponse(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
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
