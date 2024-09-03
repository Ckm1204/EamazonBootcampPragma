package com.Eamazon.Stock.application.service.Brand;

import com.Eamazon.Stock.application.dto.request.BrandRequestDTO;
import com.Eamazon.Stock.application.dto.response.BrandResponseDTO;

import java.util.List;

public interface IBrandService {


    void saveBrandInStock(BrandRequestDTO brandDto);
    List<BrandResponseDTO> getAllBrandFromStock();
}
