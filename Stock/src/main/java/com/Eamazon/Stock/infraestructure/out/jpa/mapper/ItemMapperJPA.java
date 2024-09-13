// src/main/java/com/Eamazon/Stock/infraestructure/out/jpa/mapper/ItemMapperJPA.java
package com.Eamazon.Stock.infraestructure.out.jpa.mapper;

import com.Eamazon.Stock.domain.model.request.ItemModelRequest;
import com.Eamazon.Stock.domain.model.response.ItemModelResponse;
import com.Eamazon.Stock.domain.model.response.SimpleBrandModelResponse;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Brand;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Mapper(componentModel = "spring")
public interface ItemMapperJPA {

    ItemMapperJPA INSTANCE = Mappers.getMapper(ItemMapperJPA.class);

    @Mapping(source = "brand", target = "brand.id")
    Item toItem(ItemModelRequest itemModelRequest);


    @Mapping(source = "brand", target = "brand")
    ItemModelResponse toItemModelResponse(Item item);

    List<ItemModelResponse> toItemModelResponseList(List<Item> items);



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

}