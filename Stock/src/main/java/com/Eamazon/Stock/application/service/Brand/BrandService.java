package com.Eamazon.Stock.application.service.Brand;

import com.Eamazon.Stock.application.dto.request.BrandRequestDTO;

import com.Eamazon.Stock.application.dto.response.BrandResponseDTO;
import com.Eamazon.Stock.application.mapper.BrandMapper;
import com.Eamazon.Stock.domain.api.IBrandServicePort;
import com.Eamazon.Stock.domain.model.request.BrandModelRequest;
import com.Eamazon.Stock.domain.model.response.BrandModelResponse;
import com.Eamazon.Stock.domain.paginate.NameSortingStrategy;
import com.Eamazon.Stock.domain.paginate.PaginatedResponse;
import com.Eamazon.Stock.domain.paginate.Paginator;
import com.Eamazon.Stock.domain.paginate.SimplePaginationStrategy;
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
        List<BrandModelResponse> brands = brandServicePort.getAllBrands();
        return mapper.toBrandsDTOs(brands);
    }

    public PaginatedResponse<BrandModelResponse> getPaginatedAndSortingBrands (Integer page, Integer size, boolean ascending) {
        List<BrandModelResponse> allItems = brandServicePort.getAllBrands();
        Paginator<BrandModelResponse> paginator = new Paginator<>(new SimplePaginationStrategy<>(), new NameSortingStrategy());
        List<BrandModelResponse> paginatedItems = paginator.paginateAndSort(allItems, page, size, ascending);
        int totalElements = allItems.size();
        int totalPages = (int) Math.ceil((double) totalElements / size);
        return new PaginatedResponse<>(paginatedItems, page, size, totalElements, totalPages);
    }
}
