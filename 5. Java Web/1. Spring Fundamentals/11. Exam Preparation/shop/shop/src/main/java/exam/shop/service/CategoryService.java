package exam.shop.service;

import exam.shop.model.entities.CategoryEntity;
import exam.shop.model.entities.enums.CategoryEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByName(CategoryEnum categoryEnum);

}
