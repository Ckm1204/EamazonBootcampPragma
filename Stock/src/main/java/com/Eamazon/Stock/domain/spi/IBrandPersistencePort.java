package com.Eamazon.Stock.domain.spi;

import com.Eamazon.Stock.domain.model.request.BrandModelRequest;
import com.Eamazon.Stock.domain.model.response.BrandModelResponse;

import java.util.List;
import java.util.Optional;

public interface IBrandPersistencePort {

    void createBrand(BrandModelRequest brandModelRequest);
    List<BrandModelResponse> getAllBrands();
    Optional <BrandModelRequest> findByName(String name);
}
