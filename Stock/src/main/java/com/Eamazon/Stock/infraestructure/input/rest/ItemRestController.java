package com.Eamazon.Stock.infraestructure.input.rest;

import com.Eamazon.Stock.application.dto.request.ItemRequestDTO;
import com.Eamazon.Stock.application.service.Item.ItemService;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Item;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item/")
public class ItemRestController {


    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "Crear un nuevo artículo")
    @PostMapping
    public ResponseEntity<Item> createItem(
            @RequestBody ItemRequestDTO itemRequestDTO) {
            itemService.saveItem(itemRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




}
