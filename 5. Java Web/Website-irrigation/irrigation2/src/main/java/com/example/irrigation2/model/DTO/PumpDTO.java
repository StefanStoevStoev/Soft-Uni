package com.example.irrigation2.model.DTO;

import java.math.BigDecimal;

public class PumpDTO {

    private Long id;
    private int pieces;
    private BigDecimal price;

    public PumpDTO() {
    }

    public Long getId() {
        return id;
    }

    public PumpDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public PumpDTO setPieces(int pieces) {
        this.pieces = pieces;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PumpDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
