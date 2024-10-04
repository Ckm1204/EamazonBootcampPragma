package com.Eamazon.Stock.domain.usecase;

import com.Eamazon.Stock.application.dto.request.AddStock;
import com.Eamazon.Stock.domain.api.IitemServicePort;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;
import com.Eamazon.Stock.domain.spi.IItemPersistencePort;
import com.Eamazon.Stock.infraestructure.exception.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ItemUseCase implements IitemServicePort {


    private final IItemPersistencePort itemPersistencePort;

    public ItemUseCase(IItemPersistencePort itemPersistencePort) {
        this.itemPersistencePort = itemPersistencePort;
    }


    @Override
    public void addStock( AddStock addStockQuantity) {
        // Validar que la cantidad de stock sea mayor a 0
        validateStock(addStockQuantity.getQuantity());

        // Validar que el artículo exista
        validateItemExistence(addStockQuantity.getId());

        itemPersistencePort.addStock(addStockQuantity.getId(), addStockQuantity);


    }

    @Override
    public void saveItem(ItemModelRequest item) {
        validateBrand(item.getBrand());
        validateCategories(item.getCategories());
        itemPersistencePort.createItem(item);
    }

    @Override
    public List<ItemModelResponse> getAllItems() {
        if(itemPersistencePort.getAllItems().isEmpty()){
            throw new NoDataFoundException();
        }
        return itemPersistencePort.getAllItems();
    }

    @Override
    public List<ItemModelResponse> getItemsByNameContaining(String name) {
        if(itemPersistencePort.getItemsByNameContaining(name).isEmpty()){
            throw new NoDataFoundException();
        }
        return itemPersistencePort.getItemsByNameContaining(name);
    }

    @Override
    public List<ItemModelResponse> getItemsByBrandName(String brandName) {
        if(itemPersistencePort.getItemsByBrandName(brandName).isEmpty()){
            throw new NoDataFoundException();
        }
        return itemPersistencePort.getItemsByBrandName(brandName);
    }

    @Override
    public List<ItemModelResponse> getItemsByCategoryName(String categoryName) {
        if(itemPersistencePort.getItemsByCategoryName(categoryName).isEmpty()){
            throw new NoDataFoundException();
        }
        return itemPersistencePort.getItemsByCategoryName(categoryName);
    }


    private void validateBrand(Integer brandId) {
        // Validar que el artículo esté asociado a una marca
        if (brandId == null) {
            throw new ItemBrandNotNullException();
        }
    }
    private void validateCategories(Set<Integer> categoryIds) {
        // Validar que el artículo tiene entre 1 y 3 categorías
        if (categoryIds == null || categoryIds.size() < 1 || categoryIds.size() > 3) {
            throw new ItemBetweenOneAndThreeCategoriesException();
        }
    }

    private void validateStock(int quantity) {
        // Validar que la cantidad de stock sea mayor a 0
        if (quantity <= 0) {
            throw new StockNotNegativeException();
        }
    }
    private void validateItemExistence(Integer itemId) {
        // Validar que el artículo exista
        if (!itemPersistencePort.existsById(itemId)) {
            throw new StockIdNotExistException();
        }
    }

}
