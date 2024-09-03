package com.Eamazon.Stock.infraestructure.configuration;

import com.Eamazon.Stock.domain.api.IBrandServicePort;
import com.Eamazon.Stock.domain.spi.IBrandPersistencePort;
import com.Eamazon.Stock.domain.usecase.BrandUseCase;
import com.Eamazon.Stock.infraestructure.out.jpa.adapter.BrandJpaAdapter;
import com.Eamazon.Stock.infraestructure.out.jpa.mapper.BrandMapperJPA;
import com.Eamazon.Stock.infraestructure.out.jpa.repository.IBrandRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BrandBeanConfiguration {

    private final IBrandRepository brandRepository;
    private final BrandMapperJPA brandEntityMapper;

    public BrandBeanConfiguration(IBrandRepository brandRepository, BrandMapperJPA brandEntityMapper) {
        this.brandRepository = brandRepository;
        this.brandEntityMapper = brandEntityMapper;
    }
    @Bean
    public IBrandPersistencePort brandPersistencePort() {
        return new BrandJpaAdapter(brandRepository, brandEntityMapper);
    }

    @Bean
    public IBrandServicePort brandServicePort() {
        return new BrandUseCase(brandPersistencePort());
    }

}
