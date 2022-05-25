package exam.shop.service;

import exam.shop.model.entities.enums.CategoryEnum;
import exam.shop.model.service.ProductServiceModel;
import exam.shop.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);
    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryEnum categoryEnum);


    void buyById(String id);

    void buyAll();
}
