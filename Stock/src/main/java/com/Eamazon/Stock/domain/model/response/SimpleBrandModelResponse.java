package com.Eamazon.Stock.domain.model.response;

public class SimpleBrandModelResponse {
    private Integer id;
    private String name;

    public SimpleBrandModelResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public SimpleBrandModelResponse() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
