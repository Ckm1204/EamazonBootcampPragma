package com.Eamazon.Stock.application.service.Brand;

import com.Eamazon.Stock.application.dto.request.BrandRequestDTO;

import com.Eamazon.Stock.application.dto.response.BrandResponseDTO;
import com.Eamazon.Stock.application.mapper.BrandMapper;
import com.Eamazon.Stock.domain.api.IBrandServicePort;
import com.Eamazon.Stock.domain.model.request.BrandModelRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class BrandService implements IBrandService {

    private final BrandMapper mapper ;
    private final IBrandServicePort brandServicePort;

    public BrandService(BrandMapper mapper, IBrandServicePort brandServicePort) {
        this.mapper = mapper;
        this.brandServicePort = brandServicePort;
    }


    @Override
    public void saveBrandInStock(BrandRequestDTO brandDto) {
        BrandModelRequest brand = mapper.toBrandModel(brandDto);
        brandServicePort.saveBrand(brand);

    }

    @Override
    public List<BrandResponseDTO> getAllBrandFromStock() {
        return List.of();
    }
}
