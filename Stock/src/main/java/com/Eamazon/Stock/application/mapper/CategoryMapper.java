package com.Eamazon.Stock.application.mapper;

import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.domain.model.CategoryModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryRequestDTO toCategoryDTO(CategoryModel categoryModel);
    List<CategoryRequestDTO> toCategoryDTOs(List<CategoryModel> categoriesModel);

    @InheritInverseConfiguration
    CategoryModel toCategoryModel(CategoryRequestDTO categoryrequestDTO);
    List<CategoryModel> toCategoriesModel(List<CategoryModel> categoryRequestDTOS);
}