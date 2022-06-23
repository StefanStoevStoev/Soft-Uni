package com.example.battleships;

import com.example.battleships.model.entity.CategoryEntity;
import com.example.battleships.model.entity.enums.EnumCategory;
import com.example.battleships.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategorySeed implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategorySeed(CategoryRepository category) {
        this.categoryRepository = category;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0) {
            List<CategoryEntity> category = Arrays.stream(EnumCategory.values())
                    .map(CategoryEntity::new).toList();
            category.get(0).setName(EnumCategory.BATTLE);
            category.get(1).setName(EnumCategory.CARGO);
            category.get(2).setName(EnumCategory.PATROL);

            categoryRepository.saveAll(category);
        }
    }
}
