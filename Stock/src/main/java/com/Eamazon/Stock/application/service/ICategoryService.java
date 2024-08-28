package com.Eamazon.Stock.application.service;

import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.application.dto.response.CategoryResponsetDTO;

import java.util.List;

public interface ICategoryService {
    void saveCategoryInStock(CategoryRequestDTO categorydto);
    List<CategoryResponsetDTO> getAllCategoryFromStock();
}
