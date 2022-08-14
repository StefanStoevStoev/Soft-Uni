package com.example.irrigation2.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pumps")
public class PumpEntity extends BaseEntity {

    private String kind;
    private String make;
    private String model;
    private String code;
    private String voltage;
    private String power;
    private String current;
    private String head;
    private String maxWorkingPressure;
    private String diameterInlet;
    private String diameterOutlet;
    private String weight;

    @Column(columnDefinition = "TEXT")
    private String characteristicCurve;
    private BigDecimal price;
    private LocalDate orderDate;

    private int pieces;
    private String urlPic;
    private String urlDiagram;

    @ManyToOne
    private UserEntity user;

    public PumpEntity() {
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public PumpEntity setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public PumpEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getMake() {
        return make;
    }

    public PumpEntity setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public PumpEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public String getMaxWorkingPressure() {
        return maxWorkingPressure;
    }

    public PumpEntity setMaxWorkingPressure(String maxWorkingPressure) {
        this.maxWorkingPressure = maxWorkingPressure;
        return this;
    }

    public String getCharacteristicCurve() {
        return characteristicCurve;
    }

    public PumpEntity setCharacteristicCurve(String characteristicCurve) {
        this.characteristicCurve = characteristicCurve;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public PumpEntity setPieces(int pieces) {
        this.pieces = pieces;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PumpEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getKind() {
        return kind;
    }

    public PumpEntity setKind(String kind) {
        this.kind = kind;
        return this;
    }

    public String getCode() {
        return code;
    }

    public PumpEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public String getVoltage() {
        return voltage;
    }

    public PumpEntity setVoltage(String voltage) {
        this.voltage = voltage;
        return this;
    }

    public String getPower() {
        return power;
    }

    public PumpEntity setPower(String power) {
        this.power = power;
        return this;
    }

    public String getCurrent() {
        return current;
    }

    public PumpEntity setCurrent(String current) {
        this.current = current;
        return this;
    }

    public String getHead() {
        return head;
    }

    public PumpEntity setHead(String head) {
        this.head = head;
        return this;
    }

    public String getDiameterInlet() {
        return diameterInlet;
    }

    public PumpEntity setDiameterInlet(String diameterInlet) {
        this.diameterInlet = diameterInlet;
        return this;
    }

    public String getDiameterOutlet() {
        return diameterOutlet;
    }

    public PumpEntity setDiameterOutlet(String diameterOutlet) {
        this.diameterOutlet = diameterOutlet;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public PumpEntity setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public String getUrlPic() {
        return urlPic;
    }

    public PumpEntity setUrlPic(String urlPic) {
        this.urlPic = urlPic;
        return this;
    }

    public String getUrlDiagram() {
        return urlDiagram;
    }

    public PumpEntity setUrlDiagram(String urlDiagram) {
        this.urlDiagram = urlDiagram;
        return this;
    }
}
