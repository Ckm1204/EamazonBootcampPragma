package com.Eamazon.Stock.infraestructure.out.jpa.mapper;

import com.Eamazon.Stock.domain.model.CategoryModel;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface CategoryMapperJPA {

    Category toCategory(CategoryModel categoryModel);
    CategoryModel toCategoryModel(Category category);
    List<CategoryModel> toCategoryList(List<Category> categoryList);

}
