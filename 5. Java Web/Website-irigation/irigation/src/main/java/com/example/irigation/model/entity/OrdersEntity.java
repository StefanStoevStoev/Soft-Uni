package com.example.irigation.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrdersEntity extends BaseEntity{

    @ManyToOne
    private UserEntity user;

    @ManyToMany
    private Set<PumpEntity> pump;

    @ManyToMany
    private Set<SprinklerEntity> sprinklers;

    public OrdersEntity() {
    }

    public UserEntity getUser() {
        return user;
    }

    public OrdersEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Set<PumpEntity> getPump() {
        return pump;
    }

    public OrdersEntity setPump(Set<PumpEntity> pump) {
        this.pump = pump;
        return this;
    }

    public Set<SprinklerEntity> getSprinklers() {
        return sprinklers;
    }

    public OrdersEntity setSprinklers(Set<SprinklerEntity> sprinklers) {
        this.sprinklers = sprinklers;
        return this;
    }
}
