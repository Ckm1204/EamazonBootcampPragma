package com.Eamazon.Stock.application.service;

import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.application.mapper.CategoryMapper;
import com.Eamazon.Stock.domain.api.ICategoryServicePort;
import com.Eamazon.Stock.domain.model.CategoryModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

@Transactional
public class CategoryService implements ICategoryService {


    private final CategoryMapper mapper;
    private final ICategoryServicePort categoryServicePort;

    public CategoryService(CategoryMapper mapper, ICategoryServicePort categoryServicePort) {
        this.mapper = mapper;
        this.categoryServicePort = categoryServicePort;
    }


    @Override
    public void saveCategoryInStock(CategoryRequestDTO categoryDto) {
        CategoryModel category = mapper.toCategoryModel(categoryDto);
        categoryServicePort.saveCategory(category);
    }

    @Override
    public List<CategoryRequestDTO> getAllCategoryFromStock() {

        List<CategoryModel> categories = categoryServicePort.getAllCategories();
        return mapper.toCategoryDTOs(categories);
    }
}