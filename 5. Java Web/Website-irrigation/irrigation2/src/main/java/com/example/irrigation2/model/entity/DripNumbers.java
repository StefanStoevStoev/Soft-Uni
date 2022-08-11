package com.example.irrigation2.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "drip_user")
public class DripNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "drip_id")
    private Long dripId;

    private BigDecimal price;

    private LocalDateTime registeredAt;

    private int numbers;

    public DripNumbers() {
    }

//    public DripNumbers(Long id, LocalDateTime registeredAt, int numbers) {
//        super();
//        this.id = id;
//        this.registeredAt = registeredAt;
//        this.numbers = numbers;
//    }

    public Long getId() {
        return id;
    }

    public DripNumbers setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public DripNumbers setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getDripId() {
        return dripId;
    }

    public DripNumbers setDripId(Long dripId) {
        this.dripId = dripId;
        return this;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public DripNumbers setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
        return this;
    }

    public int getNumbers() {
        return numbers;
    }

    public DripNumbers setNumbers(int numbers) {
        this.numbers = numbers;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DripNumbers setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
