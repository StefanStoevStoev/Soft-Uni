package com.example.irrigation2.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime orderDate;

    private int pieces;
    private String urlPic;
    private String urlDiagram;
    private String status;
    private int temporaryPieces;

    @OneToMany
    @JoinColumn(name = "pump_id")
    private List<SprinklerNumbers> pumpUsers;

    public PumpEntity() {
    }

    public String getStatus() {
        return status;
    }

    public PumpEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public int getTemporaryPieces() {
        return temporaryPieces;
    }

    public PumpEntity setTemporaryPieces(int temporaryPieces) {
        this.temporaryPieces = temporaryPieces;
        return this;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public PumpEntity setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public List<SprinklerNumbers> getPumpUsers() {
        return pumpUsers;
    }

    public PumpEntity setPumpUsers(List<SprinklerNumbers> pumpUsers) {
        this.pumpUsers = pumpUsers;
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
