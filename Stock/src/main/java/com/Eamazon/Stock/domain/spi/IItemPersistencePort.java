package com.Eamazon.Stock.domain.spi;

import com.Eamazon.Stock.domain.model.request.ItemModelRequest;

public interface IItemPersistencePort {
    void createItem(ItemModelRequest item);
}
