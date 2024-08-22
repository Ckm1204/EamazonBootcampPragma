package com.Eamazon.Stock.infraestructure.configuration;


/**
 import com.example.pokedex_hexagonal.infrastructure.out.mongodb.adapter.PhotoMongodbAdapter;
 import com.example.pokedex_hexagonal.infrastructure.out.mongodb.mapper.PhotoEntityMapper;
 import com.example.pokedex_hexagonal.infrastructure.out.mongodb.repository.IPhotoRepository;
 */
import com.Eamazon.Stock.domain.api.ICategoryServicePort;
import com.Eamazon.Stock.domain.spi.ICategoryPersistencePort;
import com.Eamazon.Stock.domain.usecase.CategoryUseCase;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import com.Eamazon.Stock.infraestructure.out.jpa.adapter.CategoryJpaAdapter;
import com.Eamazon.Stock.infraestructure.out.jpa.mapper.CategoryMapperJPA;
import com.Eamazon.Stock.infraestructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoryRepository categoryRepository;

    private final CategoryMapperJPA categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

}