package com.Eamazon.Stock.domain.usecase;

import com.Eamazon.Stock.domain.api.IBrandServicePort;
import com.Eamazon.Stock.domain.model.request.BrandModelRequest;
import com.Eamazon.Stock.domain.model.response.BrandModelResponse;
import com.Eamazon.Stock.domain.spi.IBrandPersistencePort;
import com.Eamazon.Stock.infraestructure.exception.BrandNameAlreadyExistException;
import com.Eamazon.Stock.infraestructure.exception.DescriptionTooLongException;
import com.Eamazon.Stock.infraestructure.exception.NameTooLongException;

import java.util.List;

public class BrandUseCase  implements IBrandServicePort {
    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public void saveBrand(BrandModelRequest brandModelRequest) {
        if(brandModelRequest.getName().length() > 50){
            throw new NameTooLongException();
        }else if (brandModelRequest.getDescription().length() > 120){
            throw new DescriptionTooLongException();
        } else if (brandPersistencePort.findByName(brandModelRequest.getName()).isPresent()) {
            throw new BrandNameAlreadyExistException();
        }else {
            brandPersistencePort.createBrand(brandModelRequest);
        }
    }

    @Override
    public List<BrandModelResponse> getAllBrands() {
        return List.of();
    }


}
