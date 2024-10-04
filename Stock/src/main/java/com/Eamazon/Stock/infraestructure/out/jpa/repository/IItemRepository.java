package com.Eamazon.Stock.infraestructure.out.jpa.repository;

import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface IItemRepository extends JpaRepository<Item, Integer> {
    Item findByName(String name);

    // Listar artículos por nombre del artículo
    List<Item> findByNameContaining(String name);

    // Listar artículos por nombre de la marca
    @Query("SELECT i FROM Item i WHERE i.brand.name = :brandName")
    List<Item> findByBrandName(@Param("brandName") String brandName);

    // Listar artículos por categoría asociada
    @Query("SELECT i FROM Item i JOIN i.categories c WHERE c.name = :categoryName")
    List<Item> findByCategoryName(@Param("categoryName") String categoryName);

    Optional<Item> findById(Integer id);

    boolean existsById(Integer id);

    //List<Item> findItemsByBrandCo
}
