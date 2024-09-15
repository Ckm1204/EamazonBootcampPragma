package com.Eamazon.Stock.infraestructure.input.rest;

import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.application.dto.response.ItemResponseDTO;
import com.Eamazon.Stock.application.service.Item.ItemService;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Item;
import io.swagger.v3.oas.annotations.Operation;
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


    @GetMapping("")
    public List<ItemResponseDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/items")
    public List<ItemResponseDTO> getItems(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) String brandName,
                                            @RequestParam(required = false) String categoryName) {

        if (name != null) {
            return itemService.getItemsByNameContaining(name);
        } else if (brandName != null) {
            return itemService.getItemsByBrandName(brandName);
        } else if (categoryName != null) {
            return itemService.getItemsByCategoryName(categoryName);
        } else {
            return itemService.getItemsByNameContaining(""); // Default to listing all items
        }
    }
}
