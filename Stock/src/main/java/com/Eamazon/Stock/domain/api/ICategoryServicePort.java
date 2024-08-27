package com.Eamazon.Stock.domain.api;

import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import com.Eamazon.Stock.domain.model.response.CategoryModelResponse;

import java.util.List;

public interface ICategoryServicePort {

    void saveCategory(CategoryModelRequest category);

    List<CategoryModelResponse> getAllCategories();


}
