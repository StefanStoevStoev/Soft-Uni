package com.example.irrigation.model.views;

public class DripViewModel {


    private Long id;
    private String name;

    private int diameter;

    private double maxPressure;
    private int distBtwDrips;
    private double flowPerDrip;
    private int size;
    private double timeOfUse;
    private double price;

    public DripViewModel() {
    }

    public Long getId() {
        return id;
    }

    public DripViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DripViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public int getDiameter() {
        return diameter;
    }

    public DripViewModel setDiameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    public double getMaxPressure() {
        return maxPressure;
    }

    public DripViewModel setMaxPressure(double maxPressure) {
        this.maxPressure = maxPressure;
        return this;
    }

    public int getDistBtwDrips() {
        return distBtwDrips;
    }

    public DripViewModel setDistBtwDrips(int distBtwDrips) {
        this.distBtwDrips = distBtwDrips;
        return this;
    }

    public double getFlowPerDrip() {
        return flowPerDrip;
    }

    public DripViewModel setFlowPerDrip(double flowPerDrip) {
        this.flowPerDrip = flowPerDrip;
        return this;
    }

    public int getSize() {
        return size;
    }

    public DripViewModel setSize(int size) {
        this.size = size;
        return this;
    }

    public double getTimeOfUse() {
        return timeOfUse;
    }

    public DripViewModel setTimeOfUse(double timeOfUse) {
        this.timeOfUse = timeOfUse;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public DripViewModel setPrice(double price) {
        this.price = price;
        return this;
    }
}
