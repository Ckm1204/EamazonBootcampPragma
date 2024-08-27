package com.Eamazon.Stock.application.service;

import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.application.mapper.CategoryMapper;
import com.Eamazon.Stock.domain.api.ICategoryServicePort;
import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CategoryServiceTest {

    @Mock
    private CategoryMapper categoryMapper;

    @Mock
    private ICategoryServicePort categoryServicePort;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCategoryInStock() {
        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO();
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();
        when(categoryMapper.toCategoryModel(any())).thenReturn(categoryModelRequest);
        doNothing().when(categoryServicePort).saveCategory(any());

        categoryService.saveCategoryInStock(categoryRequestDTO);

        verify(categoryServicePort, times(1)).saveCategory(any());
    }
}