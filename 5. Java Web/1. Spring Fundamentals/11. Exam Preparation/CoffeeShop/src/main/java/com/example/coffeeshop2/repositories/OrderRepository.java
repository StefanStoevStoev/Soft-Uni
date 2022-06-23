package com.example.coffeeshop2.repositories;

import com.example.coffeeshop2.model.entity.DTO.OrderDTO;
import com.example.coffeeshop2.model.entity.OrderEntity;
import com.example.coffeeshop2.model.entity.view.OrderViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByOrderByPriceDesc();
}
