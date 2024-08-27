package com.Eamazon.Stock.infraetructure.input.rest.jpa.adapter;

import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import com.Eamazon.Stock.infraestructure.out.jpa.adapter.CategoryJpaAdapter;
import com.Eamazon.Stock.infraestructure.out.jpa.mapper.CategoryMapperJPA;
import com.Eamazon.Stock.infraestructure.out.jpa.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CategoryJpaAdapterTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @Mock
    private CategoryMapperJPA categoryMapper;

    @InjectMocks
    private CategoryJpaAdapter categoryJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCategory() {
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();
        Category categoryEntity = new Category();

        when(categoryRepository.findByName(any())).thenReturn(Optional.empty());
        when(categoryMapper.toCategory(any())).thenReturn(categoryEntity);

        categoryJpaAdapter.createCategory(categoryModelRequest);

        verify(categoryRepository, times(1)).save(categoryEntity);
    }

    @Test
    void findByName() {
        String categoryName = "Electronics";
        Category categoryEntity = new Category();
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();

        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.of(categoryEntity));
        when(categoryMapper.toCategoryModel(categoryEntity)).thenReturn(categoryModelRequest);

        Optional<CategoryModelRequest> result = categoryJpaAdapter.findByName(categoryName);

        assertEquals(Optional.of(categoryModelRequest), result);
    }
}