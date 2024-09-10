package com.Eamazon.Stock.application.service.Item;

import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.application.dto.response.ItemResponseDTO;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;

import java.util.List;

public interface IItemService {

    void saveItem(ItemRequestDTO itemdto);
    List<ItemResponseDTO> getAllItems();

}
