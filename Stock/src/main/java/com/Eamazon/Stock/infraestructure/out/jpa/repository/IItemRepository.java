package com.Eamazon.Stock.infraestructure.out.jpa.repository;

import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByName(String name);
    Optional<Item> findByCategoriesName(String name);
    Optional<Item> findByBrandName(String name);
    Optional<Item> findByCategoriesId(Integer id);
}
