package com.Eamazon.Stock.infraetructure.input.rest.jpa.adapter;

import com.Eamazon.Stock.domain.model.CategoryModel;
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
        CategoryModel categoryModel = new CategoryModel();
        Category categoryEntity = new Category();

        when(categoryRepository.findByName(any())).thenReturn(Optional.empty());
        when(categoryMapper.toCategory(any())).thenReturn(categoryEntity);

        categoryJpaAdapter.createCategory(categoryModel);

        verify(categoryRepository, times(1)).save(categoryEntity);
    }

    @Test
    void findByName() {
        String categoryName = "Electronics";
        Category categoryEntity = new Category();
        CategoryModel categoryModel = new CategoryModel();

        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.of(categoryEntity));
        when(categoryMapper.toCategoryModel(categoryEntity)).thenReturn(categoryModel);

        Optional<CategoryModel> result = categoryJpaAdapter.findByName(categoryName);

        assertEquals(Optional.of(categoryModel), result);
    }
}