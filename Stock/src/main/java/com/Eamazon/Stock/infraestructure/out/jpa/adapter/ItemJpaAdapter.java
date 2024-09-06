package com.Eamazon.Stock.infraestructure.out.jpa.adapter;

import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.spi.IItemPersistencePort;
import com.Eamazon.Stock.infraestructure.out.jpa.mapper.ItemMapperJPA;
import com.Eamazon.Stock.infraestructure.out.jpa.repository.IItemRepository;

public class ItemJpaAdapter implements IItemPersistencePort {

    private final IItemRepository itemRepository;
    private final ItemMapperJPA itemMapper;

    public ItemJpaAdapter(IItemRepository itemRepository, ItemMapperJPA itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public void createItem(ItemModelRequest item) {
        itemRepository.save(itemMapper.toItem(item));
    }
}
