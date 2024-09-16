package com.Eamazon.Stock.application.mapper;


import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.application.dto.response.ItemResponseDTO;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.BrandModelResponse;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;
import com.Eamazon.Stock.domain.model.response.SimpleBrandModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

    //Response

    ItemResponseDTO toItemDTO(ItemModelResponse itemModelResponse);
    List<ItemResponseDTO> toItemDTOs(List<ItemModelResponse> itemModelResponse);
    List<ItemModelResponse> toItemModelsResponse(List<ItemResponseDTO> itemResponseDTOS);


    // Request
    ItemModelRequest toItemModel(ItemRequestDTO itemRequestDTO);
    List<ItemModelRequest> toItemModels(List<ItemRequestDTO> itemRequestDTOS);

    //Simple Category


}
