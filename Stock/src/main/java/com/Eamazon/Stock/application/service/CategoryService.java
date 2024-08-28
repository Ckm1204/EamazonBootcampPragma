package com.Eamazon.Stock.application.service;

import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.application.dto.response.CategoryResponsetDTO;
import com.Eamazon.Stock.application.mapper.CategoryMapper;
import com.Eamazon.Stock.domain.api.ICategoryServicePort;
import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import com.Eamazon.Stock.domain.model.response.CategoryModelResponse;
import com.Eamazon.Stock.domain.paginate.NameSortingStrategy;
import com.Eamazon.Stock.domain.paginate.PaginatedResponse;
import com.Eamazon.Stock.domain.paginate.Paginator;
import com.Eamazon.Stock.domain.paginate.SimplePaginationStrategy;
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
        CategoryModelRequest category = mapper.toCategoryModel(categoryDto);
        categoryServicePort.saveCategory(category);
    }

    @Override
    public List<CategoryResponsetDTO> getAllCategoryFromStock() {

        List<CategoryModelResponse> categories = categoryServicePort.getAllCategories();
        return mapper.toCategoryDTOs(categories);
    }

    public PaginatedResponse<CategoryModelResponse> getPaginatedAndSortedCategories(Integer page, Integer size, boolean ascending) {
        List<CategoryModelResponse> allItems = categoryServicePort.getAllCategories();
        Paginator<CategoryModelResponse> paginator = new Paginator<>(new SimplePaginationStrategy<>(), new NameSortingStrategy());
        List<CategoryModelResponse> paginatedItems = paginator.paginateAndSort(allItems, page, size, ascending);
        int totalElements = allItems.size();
        int totalPages = (int) Math.ceil((double) totalElements / size);
        return new PaginatedResponse<>(paginatedItems, page, size, totalElements, totalPages);
    }
}