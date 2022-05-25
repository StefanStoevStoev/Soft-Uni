package exam.shop.repository;

import exam.shop.model.entities.CategoryEntity;
import exam.shop.model.entities.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String > {
    Optional<CategoryEntity> findByName(CategoryEnum name);
}
