package com.Eamazon.Stock.application.mapper;


import com.Eamazon.Stock.application.dto.request.BrandRequestDTO;
import com.Eamazon.Stock.application.dto.response.BrandResponseDTO;
import com.Eamazon.Stock.domain.model.request.BrandModelRequest;
import com.Eamazon.Stock.domain.model.response.BrandModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandMapper {

    BrandResponseDTO toBrandDTO (BrandModelResponse brandModelResponse);
    List<BrandResponseDTO> toBrandsDTOs ( List<BrandModelResponse> brandsModelResponse);
    BrandModelRequest toBrandModel (BrandRequestDTO bandDTO);
    List<BrandModelRequest> toBrandModel (List<BrandModelRequest> brandsModel);
}
