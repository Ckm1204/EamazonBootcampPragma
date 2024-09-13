package com.Eamazon.Stock.application.dto.response;

import com.Eamazon.Stock.domain.model.response.BrandModelResponse;
import com.Eamazon.Stock.domain.model.response.SimpleBrandModelResponse;
import com.Eamazon.Stock.domain.model.response.SimpleCategoryModelResponse;
import com.Eamazon.Stock.domain.paginate.Nameable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDTO  {

    private Integer id;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private Set<SimpleCategoryModelResponse> categories;
    private SimpleBrandModelResponse brand;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<SimpleCategoryModelResponse> getCategories() {
        return categories;
    }

    public void setCategories(Set<SimpleCategoryModelResponse> categories) {
        this.categories = categories;
    }

    public SimpleBrandModelResponse getBrand() {
        return brand;
    }

    public void setBrand(SimpleBrandModelResponse brand) {
        this.brand = brand;
    }
}
