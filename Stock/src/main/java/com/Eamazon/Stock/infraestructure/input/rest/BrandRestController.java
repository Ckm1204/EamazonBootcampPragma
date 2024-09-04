package com.Eamazon.Stock.infraestructure.input.rest;


import com.Eamazon.Stock.application.dto.request.BrandRequestDTO;
import com.Eamazon.Stock.application.service.Brand.BrandService;
import com.Eamazon.Stock.domain.model.request.BrandModelRequest;
import com.Eamazon.Stock.domain.model.response.BrandModelResponse;
import com.Eamazon.Stock.domain.paginate.PaginatedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("")
    public PaginatedResponse<BrandModelResponse> getBrands(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "true") boolean ascending) {
        return brandService.getPaginatedAndSortingBrands(page, size, ascending);
    }




}
