package com.Eamazon.Stock.domain.model.response;

import com.Eamazon.Stock.domain.paginate.Nameable;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Brand;


import java.util.Set;


public class ItemModelResponse  implements Nameable {

    private Integer id;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private Set<Integer> categories;
    private SimpleBrandModelResponse brand;

    public Integer getId() {
        return id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Integer> getCategories() {
        return categories;
    }

    public void setCategories(Set<Integer> categories) {
        this.categories = categories;
    }

    public SimpleBrandModelResponse getBrand() {
        return brand;
    }

    public void setBrand(SimpleBrandModelResponse brand) {
        this.brand = brand;
    }
}
