package com.example.coffeeshop2.model.entity;

import com.example.coffeeshop2.model.entity.enums.ProductEnum;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private ProductEnum name;

    @Column(name = "needed_time")
    private Integer neededTime;

    public CategoryEntity(ProductEnum name) {
        this.name = name;
    }

    public CategoryEntity() {
    }

    public ProductEnum getName() {
        return name;
    }

    public CategoryEntity setName(ProductEnum name) {
        this.name = name;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public CategoryEntity setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
