package com.Eamazon.Stock.application.service.Item;

import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.application.dto.response.ItemResponseDTO;
import com.Eamazon.Stock.application.mapper.ItemMapper;
import com.Eamazon.Stock.domain.api.IitemServicePort;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ItemService implements IItemService{


    private final IitemServicePort iItemServicePort;
    private final ItemMapper mapper;


    @Override
    public void saveItem(ItemRequestDTO itemdto) {
        ItemModelRequest itemModelRequest = mapper.toItemModel(itemdto);
        iItemServicePort.saveItem(itemModelRequest);
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {

        List<ItemModelResponse> items = iItemServicePort.getAllItems();
        return mapper.toItemDTOs(items);
    }


}
