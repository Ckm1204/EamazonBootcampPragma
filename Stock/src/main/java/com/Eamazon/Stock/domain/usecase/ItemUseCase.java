package com.Eamazon.Stock.domain.usecase;

import com.Eamazon.Stock.domain.api.IitemServicePort;
import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.spi.IItemPersistencePort;
import com.Eamazon.Stock.infraestructure.exception.ItemBetweenOneAndThreeCategoriesException;
import com.Eamazon.Stock.infraestructure.exception.ItemBrandNotNullException;
import com.Eamazon.Stock.infraestructure.exception.ItemCategoriesDuplicatedException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemUseCase implements IitemServicePort {


    private final IItemPersistencePort itemPersistencePort;

    public ItemUseCase(IItemPersistencePort itemPersistencePort) {
        this.itemPersistencePort = itemPersistencePort;
    }


    @Override
    public void saveItem(ItemModelRequest item) {
        validateBrand(item.getBrand());
        validateCategories(item.getCategories());
        itemPersistencePort.createItem(item);
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

        // Validar que no haya categorías duplicadas
        Set<Integer> uniqueCategories = new HashSet<>(categoryIds);
        if (uniqueCategories.size() != categoryIds.size()) {
            throw new ItemCategoriesDuplicatedException();
        }
    }


}
