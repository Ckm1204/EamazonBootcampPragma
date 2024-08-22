package com.Eamazon.Stock.infraestructure.out.jpa.repository;

import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
