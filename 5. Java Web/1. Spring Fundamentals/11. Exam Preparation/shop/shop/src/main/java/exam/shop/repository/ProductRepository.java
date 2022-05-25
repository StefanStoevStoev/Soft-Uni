package exam.shop.repository;

import exam.shop.model.entities.ProductEntity;
import exam.shop.model.entities.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Query("SELECT SUM(p.price) FROM ProductEntity p")
    BigDecimal findTotalProductsSum();

    List<ProductEntity> findAllByCategory_Name(CategoryEnum categoryEnum);
}
