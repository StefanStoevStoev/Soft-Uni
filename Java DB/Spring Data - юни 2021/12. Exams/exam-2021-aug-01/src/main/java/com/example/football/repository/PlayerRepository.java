package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p JOIN p.stat s ORDER BY" +
            " s.shooting DESC , s.passing DESC, s.endurance DESC, p.lastName")
    List<Player> findPlayersByStatOrderByShootingDescPassingDescAndLastName();

}
