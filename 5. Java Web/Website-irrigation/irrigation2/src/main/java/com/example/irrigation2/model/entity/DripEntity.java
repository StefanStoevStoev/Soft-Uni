package com.example.irrigation2.model.entity;

import com.fasterxml.jackson.annotation.*;
//import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "drips")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@traineeId")
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
    private int pieces;
    private LocalDateTime orderDate;

    @OneToMany
    @JoinColumn(name = "drip_id")
    private List<DripNumbers> dripUsers;
    private String url;


    public DripEntity() {
    }

    public String getUrl() {
        return url;
    }

    public DripEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public DripEntity setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public List<DripNumbers> getDripUsers() {
        return dripUsers;
    }

    public DripEntity setDripUsers(List<DripNumbers> dripUsers) {
        this.dripUsers = dripUsers;
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

    public int getPieces() {
        return pieces;
    }

    public DripEntity setPieces(int pieces) {
        this.pieces = pieces;
        return this;
    }
}
