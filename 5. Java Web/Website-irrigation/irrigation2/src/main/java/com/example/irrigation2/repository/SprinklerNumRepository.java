package com.example.irrigation2.repository;

import com.example.irrigation2.model.entity.SprinklerNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprinklerNumRepository extends JpaRepository<SprinklerNumbers, Long> {

    List<SprinklerNumbers> findAllByUserIdOrderByRegisteredAtAsc(Long userId);

    List<SprinklerNumbers> findByUserIdAndSprinklerId(Long userId, Long sprId);
}
