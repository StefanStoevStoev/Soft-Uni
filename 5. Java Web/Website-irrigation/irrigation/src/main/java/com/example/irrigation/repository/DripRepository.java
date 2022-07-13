package com.example.irrigation.repository;

import com.example.irrigation.model.entity.DripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DripRepository extends JpaRepository<DripEntity, Long> {
}
