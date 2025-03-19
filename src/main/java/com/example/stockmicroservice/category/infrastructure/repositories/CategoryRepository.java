package com.example.stockmicroservice.category.infrastructure.repositories;

import com.example.stockmicroservice.category.infrastructure.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String Name);
    Page<CategoryEntity> findAll(Pageable pageable);
}
