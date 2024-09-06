package com.Eamazon.Stock.application.service.Item;

import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;

public interface IItemService {

    void saveItem(ItemRequestDTO itemdto);

}
