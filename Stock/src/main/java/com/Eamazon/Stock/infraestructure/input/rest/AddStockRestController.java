package com.Eamazon.Stock.infraestructure.input.rest;

import com.Eamazon.Stock.application.dto.request.AddStock;
import com.Eamazon.Stock.application.service.Item.ItemService;
import com.Eamazon.Stock.infraestructure.input.rest.role.RolePermissionConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock/")
public class AddStockRestController {

    private final ItemService itemService;

    public AddStockRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "Add stock to an item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Stock added successfully", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PreAuthorize(RolePermissionConstants.HAS_ROLE_AUX_BODEGA)
    @PostMapping("")
    public ResponseEntity<Void> addStockToItem(
            @Parameter(description = "Details of the stock to be added", required = true)
            @RequestBody AddStock addStock) {
        itemService.addStock(addStock);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}