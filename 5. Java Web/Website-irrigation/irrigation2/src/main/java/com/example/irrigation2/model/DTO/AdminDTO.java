package com.example.irrigation2.model.DTO;

public class AdminDTO {


    private Long userId;
    private Long id;
    private Long productId;
    private String pieces;
    private String name;

    public AdminDTO() {
    }

    public String getName() {
        return name;
    }

    public AdminDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public AdminDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public AdminDTO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getProductId() {
        return productId;
    }

    public AdminDTO setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public String getPieces() {
        return pieces;
    }

    public AdminDTO setPieces(String pieces) {
        this.pieces = pieces;
        return this;
    }
}
