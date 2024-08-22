package com.Eamazon.Stock.application.mapper;

import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryRequestDTO ToCategoryDTO(Category category);
    List<CategoryRequestDTO>
    CategoryDTOs(List<Category> categories);

    @InheritInverseConfiguration
    Category ToCategory(CategoryRequestDTO categoryrequestDTO);
    List<Category> ToCategories(List<CategoryRequestDTO> categoryRequestDTOS);
}