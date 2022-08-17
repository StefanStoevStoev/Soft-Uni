package com.example.irrigation2.repository;

import com.example.irrigation2.model.entity.PumpNumbers;
import com.example.irrigation2.model.entity.SprinklerNumbers;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PumpNumRepository extends JpaRepository<PumpNumbers, Long> {

    List<PumpNumbers> findAllByUserIdOrderByRegisteredAtAsc(Long userId);

    List<PumpNumbers> findByUserIdAndPumpId(Long userId, Long pumpId);

    List<PumpNumbers> findAllByStatus(String status, Sort sort);
}
