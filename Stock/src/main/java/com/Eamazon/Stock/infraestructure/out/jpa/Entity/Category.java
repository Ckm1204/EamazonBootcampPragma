// src/main/java/com/Eamazon/Stock/domain/entity/Category.java
package com.Eamazon.Stock.infraestructure.out.jpa.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    @Size(min = 3, max = 50)
    private String name;

    @Column(nullable = false, length = 90)
    @Size(min = 3, max = 90)
    private String description;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;



    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

 // Relationships
    @ManyToMany(mappedBy = "categories")
    private Set<Item> items;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @Size(min = 3, max = 50) String getName() {
        return name;
    }

    public void setName(@Size(min = 3, max = 50) String name) {
        this.name = name;
    }

    public @Size(min = 3, max = 90) String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 3, max = 90) String description) {
        this.description = description;
    }
}