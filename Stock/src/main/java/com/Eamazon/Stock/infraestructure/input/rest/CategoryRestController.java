package com.Eamazon.Stock.infraestructure.input.rest;


import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.application.service.CategoryService;
import com.Eamazon.Stock.domain.model.response.CategoryModelResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")

public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Add a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<Void> saveCategoryInStock(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        categoryService.saveCategoryInStock(categoryRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get paginated and sorted categories")
    @GetMapping("/")
    public List<CategoryModelResponse> getCategories(
            @Parameter(description = "Page number", example = "0") @RequestParam(defaultValue = "0") Integer page,
            @Parameter(description = "Page size", example = "10") @RequestParam(defaultValue = "10") Integer size,
            @Parameter(description = "Sort order (true for ascending, false for descending)", example = "true") @RequestParam(defaultValue = "true") boolean ascending) {
        return categoryService.getPaginatedAndSortedCategories(page, size, ascending);
    }








}
