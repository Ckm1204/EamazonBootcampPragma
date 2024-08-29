package com.Eamazon.Stock.domain.api;

import com.Eamazon.Stock.domain.model.request.BrandModelRequest;
import com.Eamazon.Stock.domain.model.response.BrandModelResponse;

import java.util.List;

public interface IBrandServicePort {

    void saveBrand(BrandModelRequest brand);

    List<BrandModelResponse> getAllBrands();
}
