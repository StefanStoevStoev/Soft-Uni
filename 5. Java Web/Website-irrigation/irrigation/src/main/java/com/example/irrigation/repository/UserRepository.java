package com.example.irrigation.repository;

import com.example.irrigation.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT count(u.id)>0 FROM UserEntity u WHERE u.email = :username")
    boolean existsByUsername(String username);

    @Query("SELECT u.password FROM UserEntity u WHERE u.email = :username")
    String findPassword(@Param("username") String username);



//    @Query("SELECT u FROM UserEntity u WHERE u.email = :username")
//    UserEntity findByEmail(String email);
}
