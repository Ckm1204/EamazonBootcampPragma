package com.Eamazon.Stock.domain.useCase;

import com.Eamazon.Stock.domain.model.request.BrandModelRequest;
import com.Eamazon.Stock.domain.model.response.BrandModelResponse;
import com.Eamazon.Stock.domain.spi.IBrandPersistencePort;
import com.Eamazon.Stock.domain.usecase.BrandUseCase;
import com.Eamazon.Stock.infraestructure.exception.BrandNameAlreadyExistException;
import com.Eamazon.Stock.infraestructure.exception.DescriptionTooLongException;
import com.Eamazon.Stock.infraestructure.exception.NameTooLongException;
import com.Eamazon.Stock.infraestructure.exception.NoDataFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BrandUseCaseTest {

    private IBrandPersistencePort brandPersistencePort;
    private BrandUseCase brandUseCase;

    @BeforeEach
    public void setUp() {
        brandPersistencePort = mock(IBrandPersistencePort.class);
        brandUseCase = new BrandUseCase(brandPersistencePort);
    }

    @Test
    public void testSaveBrand_NameTooLong() {
        BrandModelRequest request = new BrandModelRequest("A very long brand name that exceeds fifty charactersffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", "Description");

        assertThrows(DescriptionTooLongException.class, () -> brandUseCase.saveBrand(request));
    }

    @Test
    public void testSaveBrand_DescriptionTooLong() {
        BrandModelRequest request = new BrandModelRequest("BrandName", "A very long description that exceeds one hundred and twenty characters. This description is way too long to be accepted by the system.");

        assertThrows(NameTooLongException.class, () -> brandUseCase.saveBrand(request));
    }



    @Test
    public void testSaveBrand_Success() {
        BrandModelRequest request = new BrandModelRequest("BrandName", "Description");
        when(brandPersistencePort.findByName("BrandName")).thenReturn(Optional.empty());

        brandUseCase.saveBrand(request);

        verify(brandPersistencePort).createBrand(request);
    }

    @Test
    public void testGetAllBrands_NoDataFound() {
        when(brandPersistencePort.getAllBrands()).thenReturn(Collections.emptyList());

        assertThrows(NoDataFoundException.class, () -> brandUseCase.getAllBrands());
    }

    @Test
    public void testGetAllBrands_Success() {
        List<BrandModelResponse> brands = List.of(new BrandModelResponse(1, "Brand1", "Description1"), new BrandModelResponse(2, "Brand2", "Description2"));
        when(brandPersistencePort.getAllBrands()).thenReturn(brands);

        List<BrandModelResponse> result = brandUseCase.getAllBrands();

        assertEquals(brands, result);
    }
}