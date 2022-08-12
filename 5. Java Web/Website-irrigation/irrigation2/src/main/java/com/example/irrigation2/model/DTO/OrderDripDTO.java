package com.example.irrigation2.model.DTO;

import java.math.BigDecimal;

public class OrderDripDTO {

    private Long id;
    private int pieces;
    private BigDecimal price;

    public OrderDripDTO() {
    }

    public Long getId() {
        return id;
    }

    public OrderDripDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public OrderDripDTO setPieces(int pieces) {
        this.pieces = pieces;
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
