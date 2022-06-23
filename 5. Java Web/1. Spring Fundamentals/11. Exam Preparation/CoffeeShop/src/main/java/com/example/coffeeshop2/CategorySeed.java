package com.example.coffeeshop2;

import com.example.coffeeshop2.model.entity.CategoryEntity;
import com.example.coffeeshop2.model.entity.enums.ProductEnum;
import com.example.coffeeshop2.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorySeed implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategorySeed(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.categoryRepository.count() == 0) {
            List<CategoryEntity> category = Arrays.stream(ProductEnum.values())
                    .map(CategoryEntity::new)
                    .collect(Collectors.toList());
            category.get(0).setNeededTime(1);
            category.get(1).setNeededTime(2);
            category.get(2).setNeededTime(5);
            category.get(3).setNeededTime(10);

            this.categoryRepository.saveAll(category);
        }
    }
}














