package com.example.irrigation2.model.DTO;

import java.math.BigDecimal;

public class OrderDripDTO {

    private Long dripId;
    private int numbers;
    private BigDecimal price;

    public OrderDripDTO() {
    }

    public Long getDripId() {
        return dripId;
    }

    public OrderDripDTO setDripId(Long dripId) {
        this.dripId = dripId;
        return this;
    }

    public int getNumbers() {
        return numbers;
    }

    public OrderDripDTO setNumbers(int numbers) {
        this.numbers = numbers;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderDripDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
