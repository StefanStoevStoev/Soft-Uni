package com.example.irrigation.repository;

import com.example.irrigation.model.entity.SprinklerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprinklerRepository extends JpaRepository<SprinklerEntity, Long> {
}
