package com.Eamazon.Stock.infraestructure.input.rest;

import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.application.dto.response.ItemResponseDTO;
import com.Eamazon.Stock.application.service.Item.ItemService;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;
import com.Eamazon.Stock.domain.paginate.PaginatedResponse;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Item;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item/")
public class ItemRestController {

    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(
            summary = "Crear un nuevo artículo",
            description = "Permite crear un nuevo artículo en el sistema. El artículo debe tener una marca asociada y entre 1 y 3 categorías.",
            requestBody = @RequestBody(
                    description = "Cuerpo de la solicitud para crear un artículo",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ItemRequestDTO.class),
                            examples = @ExampleObject(
                                    name = "Ejemplo de creación de artículo",
                                    summary = "Ejemplo de body para crear un artículo",
                                    value = """
                    {
                        "name": "Laptop HP Pavilion2",
                        "description": "Laptop de alto rendimiento con procesador Intel Core i7",
                        "quantity": 10,
                        "price": 1200.00,
                        "brand": 1,
                        "categories": [1, 2]
                    }
                    """
                            )
                    )
            )
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Artículo creado con éxito"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o faltantes", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })

    @PostMapping
    public ResponseEntity<Item> createItem(
            @org.springframework.web.bind.annotation.RequestBody ItemRequestDTO itemRequestDTO) {
        itemService.saveItem(itemRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



    @Operation(
            summary = "Get paginated and sorted items",
            description = "Retrieve a paginated and sorted list of items. The results can be sorted in ascending or descending order, can search by name, brand name or category name.",
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
    public PaginatedResponse<ItemModelResponse> getCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "true") boolean ascending,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brandName,
            @RequestParam(required = false) String categoryName) {

        if (name != null) {
            List<ItemResponseDTO> items = itemService.getItemsByNameContaining(name);
            return itemService.getPaginatedAndSortedItems(page, size, ascending, items);
        } else if (brandName != null) {
            List<ItemResponseDTO> items = itemService.getItemsByBrandName(brandName);
            return itemService.getPaginatedAndSortedItems(page, size, ascending, items);
        } else if (categoryName != null) {
            List<ItemResponseDTO> items = itemService.getItemsByCategoryName(categoryName);
            return itemService.getPaginatedAndSortedItems(page, size, ascending, items);
        } else {
            List<ItemResponseDTO> items = itemService.getAllItems();
            return itemService.getPaginatedAndSortedItems(page, size, ascending, items); // Default to listing all items
        }
    }
}
