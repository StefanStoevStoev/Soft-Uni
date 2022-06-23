package com.example.battleships.service;

import com.example.battleships.model.entity.CategoryEntity;
import com.example.battleships.model.entity.enums.EnumCategory;
import com.example.battleships.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<CategoryEntity> findCategoryByName(EnumCategory category){
        return this.categoryRepository.findByName(category);
    }
}
