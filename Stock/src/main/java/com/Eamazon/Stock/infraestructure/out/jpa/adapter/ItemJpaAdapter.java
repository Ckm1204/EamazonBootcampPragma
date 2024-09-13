package com.Eamazon.Stock.infraestructure.out.jpa.adapter;

import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;
import com.Eamazon.Stock.domain.spi.IItemPersistencePort;
import com.Eamazon.Stock.infraestructure.exception.NoDataFoundException;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Item;
import com.Eamazon.Stock.infraestructure.out.jpa.mapper.ItemMapperJPA;
import com.Eamazon.Stock.infraestructure.out.jpa.repository.IItemRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ItemModelResponse> getAllItems() {
        List<Item> itemEntityList = itemRepository.findAll();

        if (itemEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        return itemMapper.toItemModelResponseList(itemEntityList);
    }


    @Override
    public Optional<ItemModelResponse> findByName(String name) {
        return itemRepository.findByName(name)
                .map(itemMapper::toItemModelResponse);
    }
}
