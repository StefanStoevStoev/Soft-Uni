package com.example.battleships.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class ShipEntity extends BaseEntity{

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "health", nullable = false)
    private Long health;

    @Column(name = "power", nullable = false)
    private Long power;

    @Column(name = "created",nullable = false)
    private LocalDate created;

    @ManyToOne
    private CategoryEntity category;

    @ManyToOne(optional = false)
    @JoinColumn(name="username")
    private UserEntity user;

    public ShipEntity() {
    }

    public String getName() {
        return name;
    }

    public ShipEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipEntity setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipEntity setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ShipEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ShipEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
