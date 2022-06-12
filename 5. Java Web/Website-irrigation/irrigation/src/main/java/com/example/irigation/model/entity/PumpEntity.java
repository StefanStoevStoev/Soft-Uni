package com.example.irigation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "pumps")
public class PumpEntity extends BaseEntity{

    private String make;
    private String model;
    private int power;
    private int head;
    private double maxWorkingPressure;
    private int diameterInlet;
    private int diameterOutlet;

    @Column(columnDefinition = "TEXT")
    private String characteristicCurve;

    private int pumpsCount;

    private BigDecimal price;

    public PumpEntity() {
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

    public int getPower() {
        return power;
    }

    public PumpEntity setPower(int power) {
        this.power = power;
        return this;
    }

    public int getHead() {
        return head;
    }

    public PumpEntity setHead(int head) {
        this.head = head;
        return this;
    }

    public double getMaxWorkingPressure() {
        return maxWorkingPressure;
    }

    public PumpEntity setMaxWorkingPressure(double maxWorkingPressure) {
        this.maxWorkingPressure = maxWorkingPressure;
        return this;
    }

    public int getDiameterInlet() {
        return diameterInlet;
    }

    public PumpEntity setDiameterInlet(int diameterInlet) {
        this.diameterInlet = diameterInlet;
        return this;
    }

    public int getDiameterOutlet() {
        return diameterOutlet;
    }

    public PumpEntity setDiameterOutlet(int diameterOutlet) {
        this.diameterOutlet = diameterOutlet;
        return this;
    }

    public String getCharacteristicCurve() {
        return characteristicCurve;
    }

    public PumpEntity setCharacteristicCurve(String characteristicCurve) {
        this.characteristicCurve = characteristicCurve;
        return this;
    }

    public int getPumpsCount() {
        return pumpsCount;
    }

    public PumpEntity setPumpsCount(int pumpsCount) {
        this.pumpsCount = pumpsCount;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PumpEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
