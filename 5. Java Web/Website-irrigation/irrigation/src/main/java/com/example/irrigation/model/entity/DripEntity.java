package com.example.irrigation.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "drips")
public class DripEntity extends BaseEntity {

    private String name;
    private String code;

    private int diameter;

    private double maxPressure;
    private int distBtwDrips;
    private double flowPerDrip;
    private int size;
    private String timeOfUse;
    private BigDecimal price;
    private int numbers;

    @ManyToOne
    private UserEntity userEntity;

    public DripEntity() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public DripEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public String getCode() {
        return code;
    }

    public DripEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public DripEntity setName(String name) {
        this.name = name;
        return this;
    }

    public int getDiameter() {
        return diameter;
    }

    public DripEntity setDiameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    public DripEntity setMaxPressure(double maxPressure) {
        this.maxPressure = maxPressure;
        return this;
    }

    public int getDistBtwDrips() {
        return distBtwDrips;
    }

    public DripEntity setDistBtwDrips(int distBtwDrips) {
        this.distBtwDrips = distBtwDrips;
        return this;
    }

    public double getFlowPerDrip() {
        return flowPerDrip;
    }

    public DripEntity setFlowPerDrip(double flowPerDrip) {
        this.flowPerDrip = flowPerDrip;
        return this;
    }

    public int getSize() {
        return size;
    }

    public DripEntity setSize(int size) {
        this.size = size;
        return this;
    }

    public String getTimeOfUse() {
        return timeOfUse;
    }

    public DripEntity setTimeOfUse(String timeOfUse) {
        this.timeOfUse = timeOfUse;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DripEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getNumbers() {
        return numbers;
    }

    public DripEntity setNumbers(int numbers) {
        this.numbers = numbers;
        return this;
    }
}
