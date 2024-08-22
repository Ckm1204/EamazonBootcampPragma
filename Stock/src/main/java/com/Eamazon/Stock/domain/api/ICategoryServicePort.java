package com.Eamazon.Stock.domain.api;

import com.Eamazon.Stock.domain.model.CategoryModel;

import java.util.List;

public interface ICategoryServicePort {

    void saveCategory(CategoryModel category);

    List<CategoryModel> getAllCategories();

}
