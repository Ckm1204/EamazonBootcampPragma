package com.Eamazon.Stock.application.mapper;

import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import com.Eamazon.Stock.domain.model.response.CategoryModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface CategoryMapper {


    CategoryRequestDTO toCategoryDTO(CategoryModelRequest categoryModelRequest);
    List<CategoryRequestDTO> toCategoryDTOs(List<CategoryModelResponse> categoriesModel);
    CategoryModelRequest toCategoryModel(CategoryRequestDTO categoryrequestDTO);
    List<CategoryModelRequest> toCategoriesModel(List<CategoryModelRequest> categoryRequestDTOS);
}