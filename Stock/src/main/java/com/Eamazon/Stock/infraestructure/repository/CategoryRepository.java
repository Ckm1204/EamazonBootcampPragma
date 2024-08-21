package com.Eamazon.Stock.infraestructure.repository;

import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
    Category findByDescription(String description);
    Optional<Category> findById(Integer id);
    List<Category> findAll();
    void deleteById(Integer id);
    // void deleteAll();
    Category save(Category category);
    boolean existsById(Integer id);
    boolean existsByName(String name);
    boolean existsByDescription(String description);
}
