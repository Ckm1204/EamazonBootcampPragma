package com.Eamazon.Stock.domain.useCase;

import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.spi.IItemPersistencePort;
import com.Eamazon.Stock.domain.usecase.ItemUseCase;
import com.Eamazon.Stock.infraestructure.exception.ItemBetweenOneAndThreeCategoriesException;
import com.Eamazon.Stock.infraestructure.exception.ItemBrandNotNullException;
import com.Eamazon.Stock.infraestructure.exception.ItemCategoriesDuplicatedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ItemUseCaseTest {

    private IItemPersistencePort itemPersistencePort;
    private ItemUseCase itemUseCase;

    @BeforeEach
    void setUp() {
        itemPersistencePort = Mockito.mock(IItemPersistencePort.class);
        itemUseCase = new ItemUseCase(itemPersistencePort);
    }

    @Test
    void saveItem_ShouldSaveItem_WhenValidItem() {
        ItemModelRequest item = new ItemModelRequest();
        item.setBrand(1);
        Set<Integer> categories = new HashSet<>();
        categories.add(1);
        item.setCategories(categories);

        itemUseCase.saveItem(item);

        verify(itemPersistencePort, times(1)).createItem(item);
    }

    @Test
    void saveItem_ShouldThrowException_WhenBrandIsNull() {
        ItemModelRequest item = new ItemModelRequest();
        item.setBrand(null);
        Set<Integer> categories = new HashSet<>();
        categories.add(1);
        item.setCategories(categories);

        assertThrows(ItemBrandNotNullException.class, () -> itemUseCase.saveItem(item));
    }

    @Test
    void saveItem_ShouldThrowException_WhenCategoriesAreNull() {
        ItemModelRequest item = new ItemModelRequest();
        item.setBrand(1);
        item.setCategories(null);

        assertThrows(ItemBetweenOneAndThreeCategoriesException.class, () -> itemUseCase.saveItem(item));
    }

    @Test
    void saveItem_ShouldThrowException_WhenCategoriesAreLessThanOne() {
        ItemModelRequest item = new ItemModelRequest();
        item.setBrand(1);
        Set<Integer> categories = new HashSet<>();
        item.setCategories(categories);

        assertThrows(ItemBetweenOneAndThreeCategoriesException.class, () -> itemUseCase.saveItem(item));
    }

    @Test
    void saveItem_ShouldThrowException_WhenCategoriesAreMoreThanThree() {
        ItemModelRequest item = new ItemModelRequest();
        item.setBrand(1);
        Set<Integer> categories = new HashSet<>();
        categories.add(1);
        categories.add(2);
        categories.add(3);
        categories.add(4);
        item.setCategories(categories);

        assertThrows(ItemBetweenOneAndThreeCategoriesException.class, () -> itemUseCase.saveItem(item));
    }


}