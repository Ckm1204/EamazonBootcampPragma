package com.Eamazon.Stock.infraestructure.out.jpa.repository;

import com.Eamazon.Stock.infraestructure.out.jpa.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByName(String name);
}
