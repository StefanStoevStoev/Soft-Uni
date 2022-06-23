package com.example.coffeeshop2.service;

import com.example.coffeeshop2.model.entity.CategoryEntity;
import com.example.coffeeshop2.model.entity.enums.ProductEnum;
import com.example.coffeeshop2.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity findByProductEnum(ProductEnum category){
        return categoryRepository.findByName(category).orElse(null);
    }
}
