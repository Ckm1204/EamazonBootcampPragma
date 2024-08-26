// src/test/java/com/Eamazon/Stock/domain/usecase/CategoryUseCaseTest.java
package com.Eamazon.Stock.domain.useCase;

import com.Eamazon.Stock.domain.model.CategoryModel;
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
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName("A very long category name that exceeds the limit of 50 characters");
        categoryModel.setDescription("Description");

        assertThrows(NameTooLongException.class, () -> categoryUseCase.saveCategory(categoryModel));
    }

    @Test
    void saveCategory_ShouldThrowDescriptionTooLongException() {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName("Valid Name");
        categoryModel.setDescription("A very long description that exceeds the limit of 90 characters. This description is too long.");

        assertThrows(DescriptionTooLongException.class, () -> categoryUseCase.saveCategory(categoryModel));
    }

    @Test
    void saveCategory_ShouldThrowCategoryNameAlreadyExistException() {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName("Existing Name");
        categoryModel.setDescription("Description");

        when(categoryPersistencePort.findByName(categoryModel.getName())).thenReturn(Optional.of(categoryModel));

        assertThrows(CategoryNameAlreadyExistException.class, () -> categoryUseCase.saveCategory(categoryModel));
    }

    @Test
    void saveCategory_ShouldSaveCategory() {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName("Valid Name");
        categoryModel.setDescription("Valid Description");

        when(categoryPersistencePort.findByName(categoryModel.getName())).thenReturn(Optional.empty());

        categoryUseCase.saveCategory(categoryModel);

        verify(categoryPersistencePort, times(1)).createCategory(categoryModel);
    }

    @Test
    void getAllCategories_ShouldThrowNoDataFoundException() {
        when(categoryPersistencePort.getAllCategories()).thenReturn(Collections.emptyList());

        assertThrows(NoDataFoundException.class, () -> categoryUseCase.getAllCategories());
    }

    @Test
    void getAllCategories_ShouldReturnCategories() {
        List<CategoryModel> categories = List.of(new CategoryModel());
        when(categoryPersistencePort.getAllCategories()).thenReturn(categories);

        List<CategoryModel> result = categoryUseCase.getAllCategories();

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
        Page<CategoryModel> categoriesPage = new PageImpl<>(List.of(new CategoryModel()));
        when(categoryPersistencePort.getCategoriesPage(pageRequest)).thenReturn(categoriesPage);

        Page<CategoryModel> result = categoryUseCase.getCategories(pageRequest);

        assertEquals(categoriesPage, result);
    }
}