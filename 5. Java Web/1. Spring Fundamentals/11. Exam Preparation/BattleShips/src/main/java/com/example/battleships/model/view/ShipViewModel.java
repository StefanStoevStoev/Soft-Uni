package com.example.battleships.model.view;

public class ShipViewModel {
    Long id;
    private String name;
    private Long health;
    private Long power;
    private String ownerName;

    public ShipViewModel() {
    }

    public ShipViewModel(Long id, String name, Long health, Long power, String ownerName) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.power = power;
        this.ownerName = ownerName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getHealth() {
        return health;
    }

    public Long getPower() {
        return power;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return String.format("| %s | Health: %d | Power: %d |", name, health, power);
    }

    public ShipViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public ShipViewModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public ShipViewModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public ShipViewModel setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }
}
