package com.Eamazon.Stock.infraestructure.input.rest;

import com.Eamazon.Stock.application.dto.request.AddStock;
import com.Eamazon.Stock.application.service.Item.ItemService;
import com.Eamazon.Stock.infraestructure.input.rest.role.RolePermissionConstants;
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

    // Add stock to an item
    @PreAuthorize(RolePermissionConstants.HAS_ROLE_AUX_BODEGA)
    @PostMapping("")
    public ResponseEntity<Void> addStockToItem(@RequestBody AddStock addStock) {
        itemService.addStock( addStock);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
