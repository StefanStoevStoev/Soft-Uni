package exam.repository;

import exam.model.Laptop;
import exam.model.Waranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {

    List<Laptop> findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddress();

}
