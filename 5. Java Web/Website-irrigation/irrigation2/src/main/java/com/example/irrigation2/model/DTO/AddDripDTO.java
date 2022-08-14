package com.example.irrigation2.model.DTO;

import javax.persistence.Column;
import java.math.BigDecimal;

public class AddDripDTO {

    private String name;
    @Column(unique = true)
    private String code;
    private int diameter;
    private double maxPressure;
    private int distBtwDrips;
    private double flowPerDrip;
    private int size;
    private String timeOfUse;
    private BigDecimal price;
    private int pieces;
    private int temporaryPieces;
    private String url;

    public AddDripDTO() {
    }

    public String getName() {
        return name;
    }

    public AddDripDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AddDripDTO setCode(String code) {
        this.code = code;
        return this;
    }

    public int getDiameter() {
        return diameter;
    }

    public AddDripDTO setDiameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    public AddDripDTO setMaxPressure(double maxPressure) {
        this.maxPressure = maxPressure;
        return this;
    }

    public int getDistBtwDrips() {
        return distBtwDrips;
    }

    public AddDripDTO setDistBtwDrips(int distBtwDrips) {
        this.distBtwDrips = distBtwDrips;
        return this;
    }

    public double getFlowPerDrip() {
        return flowPerDrip;
    }

    public AddDripDTO setFlowPerDrip(double flowPerDrip) {
        this.flowPerDrip = flowPerDrip;
        return this;
    }

    public int getSize() {
        return size;
    }

    public AddDripDTO setSize(int size) {
        this.size = size;
        return this;
    }

    public String getTimeOfUse() {
        return timeOfUse;
    }

    public AddDripDTO setTimeOfUse(String timeOfUse) {
        this.timeOfUse = timeOfUse;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddDripDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public AddDripDTO setPieces(int pieces) {
        this.pieces = pieces;
        return this;
    }

    public int getTemporaryPieces() {
        return temporaryPieces;
    }

    public AddDripDTO setTemporaryPieces(int temporaryPieces) {
        this.temporaryPieces = temporaryPieces;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public AddDripDTO setUrl(String url) {
        this.url = url;
        return this;
    }
}
