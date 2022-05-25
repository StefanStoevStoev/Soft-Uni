package exam.shop.service.impl;

import exam.shop.model.entities.CategoryEntity;
import exam.shop.model.entities.enums.CategoryEnum;
import exam.shop.repository.CategoryRepository;
import exam.shop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {
                        CategoryEntity categoryEntity = new CategoryEntity(categoryEnum,
                                "Description for " + categoryEnum.name());

                        categoryRepository.save(categoryEntity);
                    });
        }
    }

    @Override
    public CategoryEntity findByName(CategoryEnum categoryEnum) {
        return categoryRepository
                .findByName(categoryEnum)
                .orElse(null);
    }
}
