package com.Eamazon.Stock.domain.spi;

import com.Eamazon.Stock.domain.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface ICategoryPersistencePort {
    void createCategory(CategoryModel categoryModel);
    List<CategoryModel> getAllCategories();
    Page<CategoryModel> getCategoriesPage(PageRequest pageRequest);
    Optional <CategoryModel> findByName(String name)
    ;
}
