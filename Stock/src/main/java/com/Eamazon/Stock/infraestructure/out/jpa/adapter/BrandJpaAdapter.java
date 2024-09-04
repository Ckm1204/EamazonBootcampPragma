package com.Eamazon.Stock.infraestructure.out.jpa.adapter;

import com.Eamazon.Stock.domain.model.request.BrandModelRequest;
import com.Eamazon.Stock.domain.model.response.BrandModelResponse;
import com.Eamazon.Stock.domain.spi.IBrandPersistencePort;
import com.Eamazon.Stock.infraestructure.exception.BrandNameAlreadyExistException;
import com.Eamazon.Stock.infraestructure.exception.NoDataFoundException;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Brand;
import com.Eamazon.Stock.infraestructure.out.jpa.mapper.BrandMapperJPA;
import com.Eamazon.Stock.infraestructure.out.jpa.repository.IBrandRepository;

import java.util.List;
import java.util.Optional;

public class BrandJpaAdapter implements IBrandPersistencePort {

    private final IBrandRepository brandRepository;
    private final BrandMapperJPA brandMapper;

    public BrandJpaAdapter(IBrandRepository brandRepository, BrandMapperJPA brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public void createBrand(BrandModelRequest brandModelRequest) {
        if (brandRepository.findByName(brandModelRequest.getName()).isPresent()) {
            throw new BrandNameAlreadyExistException();
        } else brandRepository.save(brandMapper.toBrand(brandModelRequest));
    }

    @Override
    public List<BrandModelResponse> getAllBrands() {
        List<Brand> brandEntityList = brandRepository.findAll();
        if (brandEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return brandMapper.toBrandList(brandEntityList);
    }

    @Override
    public Optional<BrandModelRequest> findByName(String name) {
        return brandRepository.findByName(name)
                .map(brandMapper::toBrandModel);
    }
}
