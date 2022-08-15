package com.example.irrigation2.model.DTO;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class DripDTO {

    private Long id;
    @Positive
    private int pieces;
    private String name;
    @Positive
    private BigDecimal price;

    public DripDTO() {
    }

    public String getName() {
        return name;
    }

    public DripDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public DripDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public DripDTO setPieces(int pieces) {
        this.pieces = pieces;
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
