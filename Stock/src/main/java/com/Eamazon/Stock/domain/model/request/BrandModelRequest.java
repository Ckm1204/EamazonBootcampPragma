package com.Eamazon.Stock.domain.model.request;

public class BrandModelRequest {


    private String name;
    private String description;


    public BrandModelRequest() {
        // No-argument constructor
    }

    public BrandModelRequest(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
