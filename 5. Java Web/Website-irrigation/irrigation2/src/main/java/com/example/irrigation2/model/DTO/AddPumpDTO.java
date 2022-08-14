package com.example.irrigation2.model.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class AddPumpDTO {
    @NotBlank
    private String kind;
    @NotBlank
    private String model;
    @NotBlank
    private String make;

    @Column(unique = true)
    @NotBlank
    private String code;
    private String voltage;
    private String power;
    private String current;
    private String head;
    private String maxWorkingPressure;
    private String diameterInlet;
    private String diameterOutlet;
    private String weight;

    private BigDecimal price;
    private int pieces;
    private String urlPic;
    private String urlDiagram;

    public AddPumpDTO() {
    }

    public String getKind() {
        return kind;
    }

    public AddPumpDTO setKind(String kind) {
        this.kind = kind;
        return this;
    }

    public String getMake() {
        return make;
    }

    public AddPumpDTO setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public AddPumpDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AddPumpDTO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getVoltage() {
        return voltage;
    }

    public AddPumpDTO setVoltage(String voltage) {
        this.voltage = voltage;
        return this;
    }

    public String getPower() {
        return power;
    }

    public AddPumpDTO setPower(String power) {
        this.power = power;
        return this;
    }

    public String getCurrent() {
        return current;
    }

    public AddPumpDTO setCurrent(String current) {
        this.current = current;
        return this;
    }

    public String getHead() {
        return head;
    }

    public AddPumpDTO setHead(String head) {
        this.head = head;
        return this;
    }

    public String getMaxWorkingPressure() {
        return maxWorkingPressure;
    }

    public AddPumpDTO setMaxWorkingPressure(String maxWorkingPressure) {
        this.maxWorkingPressure = maxWorkingPressure;
        return this;
    }

    public String getDiameterInlet() {
        return diameterInlet;
    }

    public AddPumpDTO setDiameterInlet(String diameterInlet) {
        this.diameterInlet = diameterInlet;
        return this;
    }

    public String getDiameterOutlet() {
        return diameterOutlet;
    }

    public AddPumpDTO setDiameterOutlet(String diameterOutlet) {
        this.diameterOutlet = diameterOutlet;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public AddPumpDTO setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddPumpDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getPieces() {
        return pieces;
    }

    public AddPumpDTO setPieces(int pieces) {
        this.pieces = pieces;
        return this;
    }

    public String getUrlPic() {
        return urlPic;
    }

    public AddPumpDTO setUrlPic(String urlPic) {
        this.urlPic = urlPic;
        return this;
    }

    public String getUrlDiagram() {
        return urlDiagram;
    }

    public AddPumpDTO setUrlDiagram(String urlDiagram) {
        this.urlDiagram = urlDiagram;
        return this;
    }
}
