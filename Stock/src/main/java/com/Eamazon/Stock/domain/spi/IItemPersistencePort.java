package com.Eamazon.Stock.domain.spi;

import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;

import java.util.List;
import java.util.Optional;

public interface IItemPersistencePort {
    void createItem(ItemModelRequest item);
    List<ItemModelResponse> getAllItems();
    Optional<ItemModelRequest> findByName(String name);
}
