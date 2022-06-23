package com.example.coffeeshop2.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "oreders")
public class OrderEntity extends BaseEntity {

    private String name;
    private BigDecimal price;

    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @ManyToOne
    private CategoryEntity category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private UserEntity employee;

    public OrderEntity() {
    }

    public String getName() {
        return name;
    }

    public OrderEntity setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderEntity setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public OrderEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getEmployee() {
        return employee;
    }

    public OrderEntity setEmployee(UserEntity employee) {
        this.employee = employee;
        return this;
    }
}
