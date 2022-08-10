package com.example.irrigation2.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pump_user")
public class PumpNumbers {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;

    @ManyToOne
    @JoinColumn(name = "pump_id")
    DripEntity pump;

    LocalDateTime registeredAt;

    int numbers;

    public PumpNumbers() {
    }

    public Long getId() {
        return id;
    }

    public PumpNumbers setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public PumpNumbers setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public DripEntity getPump() {
        return pump;
    }

    public PumpNumbers setPump(DripEntity drip) {
        this.pump = drip;
        return this;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public PumpNumbers setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
        return this;
    }

    public int getNumbers() {
        return numbers;
    }

    public PumpNumbers setNumbers(int numbers) {
        this.numbers = numbers;
        return this;
    }
}
