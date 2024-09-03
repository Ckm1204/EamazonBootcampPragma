// src/test/java/com/Eamazon/Stock/infraestructure/input/rest/CategoryRestControllerTest.java
package com.Eamazon.Stock.infraetructure.input.rest;

import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.application.service.Category.CategoryService;
import com.Eamazon.Stock.infraestructure.input.rest.CategoryRestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

class CategoryRestControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryRestController categoryRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCategoryInStock() {
        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO();
        doNothing().when(categoryService).saveCategoryInStock(categoryRequestDTO);

        ResponseEntity<Void> response = categoryRestController.saveCategoryInStock(categoryRequestDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(categoryService).saveCategoryInStock(categoryRequestDTO);
    }
}