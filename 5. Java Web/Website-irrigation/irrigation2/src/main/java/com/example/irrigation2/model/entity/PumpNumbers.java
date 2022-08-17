package com.example.irrigation2.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pump_user")
public class PumpNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pump_id")
    private Long pumpId;

    private BigDecimal price;

    private LocalDateTime registeredAt;
    private LocalDateTime sendOn;

    private int numbers;
    private String status;

    public PumpNumbers() {
    }

    public LocalDateTime getSendOn() {
        return sendOn;
    }

    public PumpNumbers setSendOn(LocalDateTime sendOn) {
        this.sendOn = sendOn;
        return this;
    }

    public Long getId() {
        return id;
    }

    public PumpNumbers setId(Long id) {
        this.id = id;
        return this;
    }


    public Long getUserId() {
        return userId;
    }

    public PumpNumbers setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getPumpId() {
        return pumpId;
    }

    public PumpNumbers setPumpId(Long pumpId) {
        this.pumpId = pumpId;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PumpNumbers setPrice(BigDecimal price) {
        this.price = price;
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

    public String getStatus() {
        return status;
    }

    public PumpNumbers setStatus(String status) {
        this.status = status;
        return this;
    }
}
