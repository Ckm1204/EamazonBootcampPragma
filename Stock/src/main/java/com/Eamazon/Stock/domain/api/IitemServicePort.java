package com.Eamazon.Stock.domain.api;

import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;

import java.util.List;


public interface IitemServicePort {
    public void saveItem(ItemModelRequest itemdto);
    public List<ItemModelResponse> getAllItems();
}
