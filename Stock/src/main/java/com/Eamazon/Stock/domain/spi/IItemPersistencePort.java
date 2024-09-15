package com.Eamazon.Stock.domain.spi;

import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;

import java.util.List;
import java.util.Optional;

public interface IItemPersistencePort {
    void createItem(ItemModelRequest item);
    List<ItemModelResponse> getAllItems();
    Optional<ItemModelResponse> findByName(String name);
    List<ItemModelResponse> getItemsByNameContaining(String name);
    List<ItemModelResponse> getItemsByBrandName(String brandName);
    List<ItemModelResponse> getItemsByCategoryName(String categoryName);
}
