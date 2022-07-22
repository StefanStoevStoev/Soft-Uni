package com.example.irrigation.repository;

import com.example.irrigation.model.entity.PumpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PumpRepository extends JpaRepository<PumpEntity, Long> {
}
