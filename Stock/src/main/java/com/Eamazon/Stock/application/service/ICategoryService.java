package com.Eamazon.Stock.application.service;

import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;

import java.util.List;

public interface ICategoryService {
    void saveCategoryInStock(CategoryRequestDTO categorydto);
    List<CategoryRequestDTO> getAllCategoryFromStock();
}
