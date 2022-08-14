package com.example.irrigation2.model.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddSprinklerDTO {
    @NotBlank
    @Size(min = 1)
    private String kind;
    @NotBlank
    @Size(min=2)
    private String model;
    @NotBlank
    private String make;
    @NotBlank
    @Column(unique = true)
    private String code;
    private String size;
    private String pressure;
    private String nosel;
    private String volume;
    private String radius;
    private int pieces;
    private BigDecimal price;
    private LocalDate orderDate;

    @Column(columnDefinition = "TEXT")
    private String characteristicTable;
    private String image;

    public AddSprinklerDTO() {
    }

    public String getKind() {
        return kind;
    }

    public AddSprinklerDTO setKind(String kind) {
        this.kind = kind;
        return this;
    }

    public String getModel() {
        return model;
    }

    public AddSprinklerDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getMake() {
        return make;
    }

    public AddSprinklerDTO setMake(String make) {
        this.make = make;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AddSprinklerDTO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getSize() {
        return size;
    }

    public AddSprinklerDTO setSize(String size) {
        this.size = size;
        return this;
    }

    public String getPressure() {
        return pressure;
    }

    public AddSprinklerDTO setPressure(String pressure) {
        this.pressure = pressure;
        return this;
    }

    public String getNosel() {
        return nosel;
    }

    public AddSprinklerDTO setNosel(String nosel) {
        this.nosel = nosel;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    public AddSprinklerDTO setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public String getRadius() {
        return radius;
    }

    public AddSprinklerDTO setRadius(String radius) {
        this.radius = radius;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public AddSprinklerDTO setPieces(int pieces) {
        this.pieces = pieces;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddSprinklerDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public AddSprinklerDTO setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public String getCharacteristicTable() {
        return characteristicTable;
    }

    public AddSprinklerDTO setCharacteristicTable(String characteristicTable) {
        this.characteristicTable = characteristicTable;
        return this;
    }

    public String getImage() {
        return image;
    }

    public AddSprinklerDTO setImage(String image) {
        this.image = image;
        return this;
    }
}
