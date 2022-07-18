package com.example.irrigation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "pumps")
public class PumpEntity extends BaseEntity{

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
}
