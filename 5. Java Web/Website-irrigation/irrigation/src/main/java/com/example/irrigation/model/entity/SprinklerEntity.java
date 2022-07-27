package com.example.irrigation.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "sprinklers")
public class SprinklerEntity extends BaseEntity{

    private String kind;
    private String model;
    private String make;
    private String code;
    private String size;
    private String pressure;
    private String nosel;
    private String volume;
    private String radius;
    private int pieces;
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String characteristicTable;

    @ManyToOne
    private UserEntity user;

    public SprinklerEntity() {
    }

    public UserEntity getUser() {
        return user;
    }

    public SprinklerEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getKind() {
        return kind;
    }

    public SprinklerEntity setKind(String kind) {
        this.kind = kind;
        return this;
    }

    public String getMake() {
        return make;
    }

    public SprinklerEntity setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public SprinklerEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public String getCharacteristicTable() {
        return characteristicTable;
    }

    public SprinklerEntity setCharacteristicTable(String characteristicTable) {
        this.characteristicTable = characteristicTable;
        return this;
    }

    public String getCode() {
        return code;
    }

    public SprinklerEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public String getSize() {
        return size;
    }

    public SprinklerEntity setSize(String size) {
        this.size = size;
        return this;
    }

    public String getPressure() {
        return pressure;
    }

    public SprinklerEntity setPressure(String pressure) {
        this.pressure = pressure;
        return this;
    }

    public String getNosel() {
        return nosel;
    }

    public SprinklerEntity setNosel(String nosel) {
        this.nosel = nosel;
        return this;
    }

    public String getRadius() {
        return radius;
    }

    public SprinklerEntity setRadius(String radius) {
        this.radius = radius;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    public SprinklerEntity setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public SprinklerEntity setPieces(int pieces) {
        this.pieces = pieces;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SprinklerEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

}
