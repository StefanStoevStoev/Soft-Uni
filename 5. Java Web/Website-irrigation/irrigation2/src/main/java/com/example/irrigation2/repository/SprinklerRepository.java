package com.example.irrigation2.repository;

import com.example.irrigation2.model.entity.SprinklerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprinklerRepository extends JpaRepository<SprinklerEntity, Long> {
}
