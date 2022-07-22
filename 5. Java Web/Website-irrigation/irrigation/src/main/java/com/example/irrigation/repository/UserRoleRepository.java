package com.example.irrigation.repository;

import com.example.irrigation.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<RoleEntity, Long> {
}
