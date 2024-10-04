package com.Eamazon.Stock.domain.spi;

import com.Eamazon.Stock.application.dto.request.AddStock;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IItemPersistencePort {

    boolean existsById(Integer itemId);
    void addStock(Integer itemId, AddStock quantity);
    void createItem(ItemModelRequest item);
    List<ItemModelResponse> getAllItems();
    Optional<ItemModelResponse> findByName(String name);
    List<ItemModelResponse> getItemsByNameContaining(String name);
    List<ItemModelResponse> getItemsByBrandName(String brandName);
    List<ItemModelResponse> getItemsByCategoryName(String categoryName);
}
