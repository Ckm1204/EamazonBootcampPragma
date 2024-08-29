package com.Eamazon.Stock.infraestructure.out.jpa.mapper;


import com.Eamazon.Stock.domain.model.request.BrandModelRequest;
import com.Eamazon.Stock.domain.model.response.BrandModelResponse;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandMapperJPA {

    Brand toBrand(BrandModelRequest brandModelRequest);
    BrandModelRequest toBrandModel (Brand brand);
    BrandModelResponse toBrandModelResponse(Brand brand);
    List<BrandModelResponse> toBrandList(List<Brand> brandList);


}
