// src/test/java/com/Eamazon/Stock/domain/usecase/CategoryUseCaseTest.java
package com.Eamazon.Stock.domain.useCase;

import com.Eamazon.Stock.domain.model.request.CategoryModelRequest;
import com.Eamazon.Stock.domain.spi.ICategoryPersistencePort;
import com.Eamazon.Stock.domain.usecase.CategoryUseCase;
import com.Eamazon.Stock.infraestructure.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCategory_ShouldThrowNameTooLongException() {
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();
        categoryModelRequest.setName("A very long category name that exceeds the limit of 50 characters");
        categoryModelRequest.setDescription("Description");

        assertThrows(NameTooLongException.class, () -> categoryUseCase.saveCategory(categoryModelRequest));
    }

    @Test
    void saveCategory_ShouldThrowDescriptionTooLongException() {
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();
        categoryModelRequest.setName("Valid Name");
        categoryModelRequest.setDescription("A very long description that exceeds the limit of 90 characters. This description is too long.");

        assertThrows(DescriptionTooLongException.class, () -> categoryUseCase.saveCategory(categoryModelRequest));
    }

    @Test
    void saveCategory_ShouldThrowCategoryNameAlreadyExistException() {
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();
        categoryModelRequest.setName("Existing Name");
        categoryModelRequest.setDescription("Description");

        when(categoryPersistencePort.findByName(categoryModelRequest.getName())).thenReturn(Optional.of(categoryModelRequest));

        assertThrows(CategoryNameAlreadyExistException.class, () -> categoryUseCase.saveCategory(categoryModelRequest));
    }

    @Test
    void saveCategory_ShouldSaveCategory() {
        CategoryModelRequest categoryModelRequest = new CategoryModelRequest();
        categoryModelRequest.setName("Valid Name");
        categoryModelRequest.setDescription("Valid Description");

        when(categoryPersistencePort.findByName(categoryModelRequest.getName())).thenReturn(Optional.empty());

        categoryUseCase.saveCategory(categoryModelRequest);

        verify(categoryPersistencePort, times(1)).createCategory(categoryModelRequest);
    }

    @Test
    void getAllCategories_ShouldThrowNoDataFoundException() {
        when(categoryPersistencePort.getAllCategories()).thenReturn(Collections.emptyList());

        assertThrows(NoDataFoundException.class, () -> categoryUseCase.getAllCategories());
    }

    @Test
    void getAllCategories_ShouldReturnCategories() {
        List<CategoryModelRequest> categories = List.of(new CategoryModelRequest());
        when(categoryPersistencePort.getAllCategories()).thenReturn(categories);

        List<CategoryModelRequest> result = categoryUseCase.getAllCategories();

        assertEquals(categories, result);
    }

    @Test
    void getCategories_ShouldThrowNoDataFoundException() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        when(categoryPersistencePort.getCategoriesPage(pageRequest)).thenReturn(Page.empty());

        assertThrows(NoDataFoundException.class, () -> categoryUseCase.getCategories(pageRequest));
    }

    @Test
    void getCategories_ShouldReturnCategoriesPage() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<CategoryModelRequest> categoriesPage = new PageImpl<>(List.of(new CategoryModelRequest()));
        when(categoryPersistencePort.getCategoriesPage(pageRequest)).thenReturn(categoriesPage);

        Page<CategoryModelRequest> result = categoryUseCase.getCategories(pageRequest);

        assertEquals(categoriesPage, result);
    }
}