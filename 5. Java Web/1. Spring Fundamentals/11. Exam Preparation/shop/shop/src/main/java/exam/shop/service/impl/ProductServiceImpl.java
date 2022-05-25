package exam.shop.service.impl;

import exam.shop.model.entities.ProductEntity;
import exam.shop.model.entities.enums.CategoryEnum;
import exam.shop.model.service.ProductServiceModel;
import exam.shop.model.view.ProductViewModel;
import exam.shop.repository.ProductRepository;
import exam.shop.service.CategoryService;
import exam.shop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        ProductEntity product = modelMapper.map(productServiceModel, ProductEntity.class);
        product
                .setCategory(categoryService
                        .findByName(productServiceModel
                                .getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        if(productRepository.findTotalProductsSum() == null){
            return BigDecimal.valueOf(0);
        }
        return productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryEnum categoryEnum) {

        return productRepository
                .findAllByCategory_Name(categoryEnum)
                .stream()
                .map(product ->modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
