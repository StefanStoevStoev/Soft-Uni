package com.example.coffeeshop2.repositories;

import com.example.coffeeshop2.model.entity.UserEntity;
import com.example.coffeeshop2.model.entity.view.UserViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u from UserEntity as u order by size(u.orders) DESC")
    List<UserEntity> findAllByOrdersCountDescending();
}
