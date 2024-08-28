package com.Eamazon.Stock.infraestructure.configuration;


/**
 import com.example.pokedex_hexagonal.infrastructure.out.mongodb.adapter.PhotoMongodbAdapter;
 import com.example.pokedex_hexagonal.infrastructure.out.mongodb.mapper.PhotoEntityMapper;
 import com.example.pokedex_hexagonal.infrastructure.out.mongodb.repository.IPhotoRepository;
 */
import com.Eamazon.Stock.domain.api.ICategoryServicePort;
import com.Eamazon.Stock.domain.spi.ICategoryPersistencePort;
import com.Eamazon.Stock.domain.usecase.CategoryUseCase;
import com.Eamazon.Stock.infraestructure.out.jpa.adapter.CategoryJpaAdapter;
import com.Eamazon.Stock.infraestructure.out.jpa.mapper.CategoryMapperJPA;
import com.Eamazon.Stock.infraestructure.out.jpa.repository.ICategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class BeanConfiguration {

    private final ICategoryRepository categoryRepository;
    private final CategoryMapperJPA categoryEntityMapper;

    public BeanConfiguration(ICategoryRepository categoryRepository, CategoryMapperJPA categoryEntityMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

}