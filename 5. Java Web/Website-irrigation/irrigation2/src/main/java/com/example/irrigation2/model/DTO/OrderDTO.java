package com.example.irrigation2.model.DTO;

import java.math.BigDecimal;

public class OrderDTO {

    private Long id;
    private String name;
    private int pieces;
    private BigDecimal price;

    public OrderDTO() {
    }

    public String getName() {
        return name;
    }

    public OrderDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OrderDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public OrderDTO setPieces(int pieces) {
        this.pieces = pieces;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
