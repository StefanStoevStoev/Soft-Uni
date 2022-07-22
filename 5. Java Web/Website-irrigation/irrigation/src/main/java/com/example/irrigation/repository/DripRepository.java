package com.example.irrigation.repository;

import com.example.irrigation.model.entity.DripEntity;
import com.example.irrigation.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DripRepository extends JpaRepository<DripEntity, Long> {

    List<DripEntity> findByUserEntity(UserEntity userEntity);
}
