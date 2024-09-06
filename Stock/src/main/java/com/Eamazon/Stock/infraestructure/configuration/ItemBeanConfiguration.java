package com.Eamazon.Stock.infraestructure.configuration;

import com.Eamazon.Stock.domain.api.IitemServicePort;
import com.Eamazon.Stock.domain.spi.IItemPersistencePort;
import com.Eamazon.Stock.domain.usecase.ItemUseCase;
import com.Eamazon.Stock.infraestructure.out.jpa.adapter.ItemJpaAdapter;
import com.Eamazon.Stock.infraestructure.out.jpa.mapper.ItemMapperJPA;
import com.Eamazon.Stock.infraestructure.out.jpa.repository.IItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ItemBeanConfiguration {

    private final IItemRepository itemRepository;
    private final ItemMapperJPA itemEntityMapper;

    public ItemBeanConfiguration(IItemRepository itemRepository, ItemMapperJPA itemEntityMapper) {
        this.itemRepository = itemRepository;
        this.itemEntityMapper = itemEntityMapper;
    }

    @Bean
    public IItemPersistencePort itemPersistencePort() {
        return new ItemJpaAdapter(itemRepository, itemEntityMapper);
    }

    @Bean
    public IitemServicePort itemServicePort() {
        return new ItemUseCase(itemPersistencePort());
    }
}
