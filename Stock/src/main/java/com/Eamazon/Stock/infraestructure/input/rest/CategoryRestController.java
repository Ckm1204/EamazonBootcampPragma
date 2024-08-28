package com.Eamazon.Stock.infraestructure.input.rest;


import com.Eamazon.Stock.application.dto.request.CategoryRequestDTO;
import com.Eamazon.Stock.application.service.CategoryService;
import com.Eamazon.Stock.domain.model.response.CategoryModelResponse;
import com.Eamazon.Stock.domain.paginate.PaginatedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/category/")

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

    @Operation(
    summary = "Get paginated and sorted categories",
    description = "Retrieve a paginated and sorted list of categories. The results can be sorted in ascending or descending order.",
    parameters = {
        @Parameter(name = "page", description = "Page number to retrieve", example = "0"),
        @Parameter(name = "size", description = "Number of items per page", example = "10"),
        @Parameter(name = "ascending", description = "Sort order: true for ascending, false for descending", example = "true")
    },
    responses = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved categories", content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "400", description = "Invalid request parameters", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    }
)
@GetMapping("")
public PaginatedResponse<CategoryModelResponse> getCategories(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "true") boolean ascending) {
    return categoryService.getPaginatedAndSortedCategories(page, size, ascending);
}








}
