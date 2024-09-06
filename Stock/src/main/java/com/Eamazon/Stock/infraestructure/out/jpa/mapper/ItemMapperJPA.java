package com.Eamazon.Stock.infraestructure.out.jpa.mapper;

import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.Set;
import java.util.HashSet;

@Mapper(componentModel = "spring")

public interface ItemMapperJPA {

    ItemMapperJPA INSTANCE = Mappers.getMapper(ItemMapperJPA.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "brand", target = "brand.id")
    @Mapping(source = "categories", target = "categories")
    Item toItem(ItemModelRequest itemModelRequest);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "brand.id", target = "brand")
    @Mapping(source = "categories", target = "categories")
    ItemModelRequest toItemModelRequest(Item item);

    default Set<Category> mapCategoryIdsToCategories(Set<Integer> categoryIds) {
        if (categoryIds == null) {
            return null;
        }
        Set<Category> categories = new HashSet<>();
        for (Integer id : categoryIds) {
            Category category = new Category(); // Assuming Category has a no-args constructor
            category.setId(id);
            categories.add(category);
        }
        return categories;
    }

    default Set<Integer> mapCategoriesToCategoryIds(Set<Category> categories) {
        if (categories == null) {
            return null;
        }
        Set<Integer> categoryIds = new HashSet<>();
        for (Category category : categories) {
            categoryIds.add(category.getId());
        }
        return categoryIds;
    }
}
