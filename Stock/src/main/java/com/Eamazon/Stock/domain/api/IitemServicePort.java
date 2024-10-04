package com.Eamazon.Stock.domain.api;

import com.Eamazon.Stock.application.dto.request.AddStock;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;

import java.util.List;


public interface IitemServicePort {

    public void addStock( AddStock addStockQuantity);
    public void saveItem(ItemModelRequest itemdto);
    public List<ItemModelResponse> getAllItems();
    public List<ItemModelResponse> getItemsByNameContaining(String name);
    public List<ItemModelResponse> getItemsByBrandName(String brandName);
    public List<ItemModelResponse> getItemsByCategoryName(String categoryName);
}
