package com.example.coffeeshop2.repositories;

import com.example.coffeeshop2.model.entity.CategoryEntity;
import com.example.coffeeshop2.model.entity.enums.ProductEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByName(ProductEnum name);
}
