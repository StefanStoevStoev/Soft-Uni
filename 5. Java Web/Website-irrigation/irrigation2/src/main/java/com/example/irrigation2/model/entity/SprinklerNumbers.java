package com.example.irrigation2.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sprinkler_user")
public class SprinklerNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "sprinkler_id")
    private Long sprinklerId;

    private BigDecimal price;

    private LocalDateTime registeredAt;

    private int numbers;
    private String status;

    public SprinklerNumbers() {
    }

    public Long getId() {
        return id;
    }

    public SprinklerNumbers setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public SprinklerNumbers setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getSprinklerId() {
        return sprinklerId;
    }

    public SprinklerNumbers setSprinklerId(Long sprinklerId) {
        this.sprinklerId = sprinklerId;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SprinklerNumbers setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public SprinklerNumbers setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
        return this;
    }

    public int getNumbers() {
        return numbers;
    }

    public SprinklerNumbers setNumbers(int numbers) {
        this.numbers = numbers;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SprinklerNumbers setStatus(String status) {
        this.status = status;
        return this;
    }
}
