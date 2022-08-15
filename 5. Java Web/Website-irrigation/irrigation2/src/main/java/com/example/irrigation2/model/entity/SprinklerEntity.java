package com.example.irrigation2.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sprinklers")
public class SprinklerEntity extends BaseEntity {

    private String kind;
    private String model;
    private String make;
    @Column(unique = true)
    private String code;
    private String size;
    private String pressure;
    private String nosel;
    private String volume;
    private String radius;
    private int pieces;
    private BigDecimal price;
    private LocalDateTime orderDate;
    private int temporaryPieces;

    @Column(columnDefinition = "TEXT")
    private String characteristicTable;
    private String url;
    private String status;

    @OneToMany
    @JoinColumn(name = "sprinkler_id")
    private List<SprinklerNumbers> sprinklerUsers;

    public SprinklerEntity() {
    }

    public List<SprinklerNumbers> getSprinklerUsers() {
        return sprinklerUsers;
    }

    public SprinklerEntity setSprinklerUsers(List<SprinklerNumbers> sprinklerUsers) {
        this.sprinklerUsers = sprinklerUsers;
        return this;
    }

    public int getTemporaryPieces() {
        return temporaryPieces;
    }

    public SprinklerEntity setTemporaryPieces(int temporaryPieces) {
        this.temporaryPieces = temporaryPieces;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SprinklerEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public SprinklerEntity setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
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

    public String getUrl() {
        return url;
    }

    public SprinklerEntity setUrl(String url) {
        this.url = url;
        return this;
    }
}
