package com.Eamazon.Stock.domain.spi;

import com.Eamazon.Stock.domain.model.CategoryModel;

import java.util.List;

public interface ICategoryPersistencePort {
    void createCategory(CategoryModel categoryModel);
    List<CategoryModel> getAllCategories();
}
