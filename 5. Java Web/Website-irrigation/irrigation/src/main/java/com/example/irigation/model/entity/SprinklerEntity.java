package com.example.irigation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sprinklers")
public class SprinklerEntity extends BaseEntity{

    private String make;
    private String model;
    private String description;
    private String material;
    @Column(columnDefinition = "TEXT")
    private String characteristicTable;

    public SprinklerEntity() {
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

    public String getDescription() {
        return description;
    }

    public SprinklerEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMaterial() {
        return material;
    }

    public SprinklerEntity setMaterial(String material) {
        this.material = material;
        return this;
    }

    public String getCharacteristicTable() {
        return characteristicTable;
    }

    public SprinklerEntity setCharacteristicTable(String characteristicTable) {
        this.characteristicTable = characteristicTable;
        return this;
    }
}
