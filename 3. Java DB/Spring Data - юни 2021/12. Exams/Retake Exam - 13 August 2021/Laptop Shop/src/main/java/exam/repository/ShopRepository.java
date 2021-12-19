package exam.repository;

import exam.model.Shop;
import exam.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    boolean existsByName(String name);

    Shop findAllByName(String name);
}
