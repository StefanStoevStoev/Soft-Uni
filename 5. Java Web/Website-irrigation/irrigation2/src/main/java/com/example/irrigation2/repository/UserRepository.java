package com.example.irrigation2.repository;

import com.example.irrigation2.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT count(u.id)>0 FROM UserEntity u WHERE u.email = :username")
    boolean existsByUsername(String username);

    @Query("SELECT u.password FROM UserEntity u WHERE u.email = :username")
    String findPassword(@Param("username") String username);



    @Query("SELECT u, COUNT(s.sprinklerId) FROM UserEntity u JOIN SprinklerNumbers AS s GROUP BY u.id ORDER BY  s.sprinklerId DESC")
    List<UserEntity> getAllOrderByUsersSprinklerDesc();

    @Query("SELECT u, COUNT(p.pumpId) FROM UserEntity u JOIN PumpNumbers AS p GROUP BY u.id ORDER BY  p.pumpId DESC")
    List<UserEntity> getAllOrderByUsersPumpDesc();

    @Query("SELECT u, COUNT(d.dripId) FROM UserEntity u JOIN DripNumbers AS d GROUP BY u.id ORDER BY  d.dripId DESC")
    List<UserEntity> getAllOrderByUsersDripDesc();
}
