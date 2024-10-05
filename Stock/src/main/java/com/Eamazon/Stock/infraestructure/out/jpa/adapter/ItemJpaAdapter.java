package com.Eamazon.Stock.infraestructure.out.jpa.adapter;

import com.Eamazon.Stock.application.dto.request.AddStock;
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
    public boolean existsById(Integer itemId) {
        return itemRepository.existsById(itemId);
    }


    // this method added stock to an item
    @Override
    public void addStock(Integer itemId, AddStock quantity) {
        Item item = getItemFromOptional(itemRepository.findById(itemId));
        item.setQuantity(item.getQuantity() + quantity.getQuantity());
        itemRepository.save(item);


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
        Item item = itemRepository.findByName(name);
        return Optional.ofNullable(itemMapper.toItemModelResponse(item));

    }
    @Override
    public List<ItemModelResponse> getItemsByNameContaining(String name) {
        List<ItemModelResponse> items = itemMapper.toItemModelResponseList(itemRepository.findByNameContaining(name));
        return items ;
    }
    @Override
    public List<ItemModelResponse> getItemsByBrandName(String brandName) {
        List<ItemModelResponse> items = itemMapper.toItemModelResponseList(itemRepository.findByBrandName(brandName));
        return items;
    }
    @Override
    public List<ItemModelResponse> getItemsByCategoryName(String categoryName) {
        List<ItemModelResponse> items = itemMapper.toItemModelResponseList(itemRepository.findByCategoryName(categoryName));
        return items;
    }

    public Item getItemFromOptional(Optional<Item> optionalItem) {
        return optionalItem.orElseThrow(() -> new NoDataFoundException());
    }


}
