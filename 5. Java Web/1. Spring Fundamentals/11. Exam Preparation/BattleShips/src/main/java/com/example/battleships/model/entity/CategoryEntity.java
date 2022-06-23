package com.example.battleships.model.entity;

import com.example.battleships.model.entity.enums.EnumCategory;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private EnumCategory name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryEntity() {
    }
    public CategoryEntity(EnumCategory t) {
    }

    public EnumCategory getName() {
        return name;
    }

    public CategoryEntity setName(EnumCategory name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
