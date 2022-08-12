package com.example.irrigation2.repository;

import com.example.irrigation2.model.entity.DripNumbers;
import com.example.irrigation2.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DripNumRepository extends JpaRepository<DripNumbers, Long> {

    List<DripNumbers> findAllByUserIdOrderByRegisteredAtAsc(Long userId);

    DripNumbers findByUserIdAndDripId(Long userId, Long dripId);
}
