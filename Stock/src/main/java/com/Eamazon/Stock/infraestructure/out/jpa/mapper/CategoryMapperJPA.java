package com.Eamazon.Stock.infraestructure.out.jpa.mapper;

import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import com.Eamazon.Stock.domain.model.response.CategoryModelResponse;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface CategoryMapperJPA {


    Category toCategory(CategoryModelRequest categoryModelRequest);
    CategoryModelRequest toCategoryModel(Category category);
    CategoryModelResponse toCategoryModelResponse(Category category);
    List<CategoryModelResponse> toCategoryList(List<Category> categoryList);

}
