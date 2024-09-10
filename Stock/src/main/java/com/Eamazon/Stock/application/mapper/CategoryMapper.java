package com.Eamazon.Stock.application.mapper;

import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.application.dto.response.CategoryResponsetDTO;
import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import com.Eamazon.Stock.domain.model.response.CategoryModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface CategoryMapper {

    // Response
    CategoryResponsetDTO toCategoryDTO(CategoryModelResponse categoryModelResponse);
    List<CategoryResponsetDTO> toCategoryDTOs(List<CategoryModelResponse> categoriesModel);

    // Request
    CategoryModelRequest toCategoryModel(CategoryRequestDTO categoryrequestDTO);
    List<CategoryModelRequest> toCategoriesModel(List<CategoryModelRequest> categoryRequestDTOS);
}