package com.example.irrigation2.model.DTO;

import java.math.BigDecimal;

public class SprinklerDTO {

    private Long id;
    private int pieces;
    private BigDecimal price;

    public SprinklerDTO() {
    }

    public Long getId() {
        return id;
    }

    public SprinklerDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public SprinklerDTO setPieces(int pieces) {
        this.pieces = pieces;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SprinklerDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
