package com.example.irrigation2.repository;

import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DripRepository extends JpaRepository<DripEntity, Long> {

    List<DripEntity> findByUserEntityId(Long id);
}
