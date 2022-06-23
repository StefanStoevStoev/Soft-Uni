package com.example.battleships.repository;

import com.example.battleships.model.entity.ShipEntity;
import com.example.battleships.model.view.ShipViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {

    @Query("SELECT new com.example.battleships.model.view.ShipViewModel(s.id, s.name, s.health, s.power, u.username)" +
            " " +
            "FROM ShipEntity s " +
            "JOIN s.user u")
    List<ShipViewModel> findAllShips();
    Optional<ShipEntity> findByName(String shipName);
    Optional<ShipEntity> findById(Long shipName);
}
