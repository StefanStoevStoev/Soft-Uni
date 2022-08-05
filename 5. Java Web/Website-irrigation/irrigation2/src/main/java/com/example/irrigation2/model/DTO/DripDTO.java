package com.example.irrigation2.model.DTO;

import java.math.BigDecimal;

public class DripDTO {
    private Long id;
    private int numbers;
    private BigDecimal price;

    public DripDTO() {
    }

    public Long getId() {
        return id;
    }

    public DripDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public int getNumbers() {
        return numbers;
    }

    public DripDTO setNumbers(int numbers) {
        this.numbers = numbers;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DripDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
