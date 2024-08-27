package com.Eamazon.Stock.domain.spi;

import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import com.Eamazon.Stock.domain.model.response.CategoryModelResponse;

import java.util.List;
import java.util.Optional;

public interface ICategoryPersistencePort {
    void createCategory(CategoryModelRequest categoryModelRequest);
    List<CategoryModelResponse> getAllCategories();
    Optional <CategoryModelRequest> findByName(String name)
    ;
}
