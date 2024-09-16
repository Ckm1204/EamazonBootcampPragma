package com.Eamazon.Stock.domain.model.response;

public class SimpleCategoryModelResponse {

    private Integer id;
    private String name;


    public SimpleCategoryModelResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public SimpleCategoryModelResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
