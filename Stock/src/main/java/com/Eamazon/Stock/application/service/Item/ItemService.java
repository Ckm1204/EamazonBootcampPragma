package com.Eamazon.Stock.application.service.Item;

import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.application.mapper.ItemMapper;
import com.Eamazon.Stock.domain.api.IitemServicePort;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
