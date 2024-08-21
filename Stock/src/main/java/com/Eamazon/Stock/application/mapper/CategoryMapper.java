package com.Eamazon.Stock.application.mapper;

import com.Eamazon.Stock.application.dto.CategoryDTO;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO ToCategoryDTO(Category category);
    List<CategoryDTO> CategoryDTOs(List<Category> categories);
    @InheritInverseConfiguration
    Category ToCategory(CategoryDTO categoryDTO);
    List<Category> ToCategories(List<CategoryDTO> categoryDTOs);
}