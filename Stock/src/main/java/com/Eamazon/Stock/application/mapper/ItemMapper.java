package com.Eamazon.Stock.application.mapper;


import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {



    // Request
    ItemModelRequest toItemModel(ItemRequestDTO itemRequestDTO);
    List<ItemModelRequest> toItemModels(List<ItemRequestDTO> itemRequestDTOS);



}
