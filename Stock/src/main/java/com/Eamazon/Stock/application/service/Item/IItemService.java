package com.Eamazon.Stock.application.service.Item;

import com.Eamazon.Stock.application.dto.request.AddStock;
import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.application.dto.response.ItemResponseDTO;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;

import java.util.List;

public interface IItemService {

    void addStock( AddStock addStockQuantity);
    void saveItem(ItemRequestDTO itemdto);
    List<ItemResponseDTO> getAllItems();
    List<ItemResponseDTO> getItemsByNameContaining(String name);
    List<ItemResponseDTO> getItemsByBrandName(String brandName);
    List<ItemResponseDTO> getItemsByCategoryName(String categoryName);

}
