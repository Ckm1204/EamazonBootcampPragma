package com.Eamazon.Stock.application.dto.request;

public class AddStock {



    private Integer id;
    private Integer quantity;

    public AddStock() {
    }



    public AddStock(Integer quantity, Integer id) {
        this.quantity = quantity;
        this.id = id;
    }



    public Integer getQuantity() {
        return this.quantity;
    }



    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    public AddStock quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }



    public Integer getId() {
        return this.id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
}
