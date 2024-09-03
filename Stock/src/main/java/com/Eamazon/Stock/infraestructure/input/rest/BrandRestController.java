package com.Eamazon.Stock.infraestructure.input.rest;


import com.Eamazon.Stock.application.dto.request.BrandRequestDTO;
import com.Eamazon.Stock.application.service.Brand.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand/")
public class BrandRestController {

    private final BrandService brandService;

    public BrandRestController(BrandService brandService) {
        this.brandService = brandService;
    }

    // Add a new brand

    @PostMapping("")
    public ResponseEntity<Void> saveBrandInStock(@RequestBody BrandRequestDTO brandRequestDTO) {
        brandService.saveBrandInStock(brandRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}
