package com.example.exam25.repository;

import com.example.exam25.model.entity.StyleEntity;
import com.example.exam25.model.entity.enums.StyleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<StyleEntity, Long> {

    StyleEntity findByName(StyleEnum name);

    Optional<StyleEntity> findStyleEntityByName(StyleEnum style);
}
