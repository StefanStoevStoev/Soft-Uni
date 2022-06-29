package com.example.exam25.model.entity;

import com.example.exam25.model.entity.enums.StyleEnum;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class StyleEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private StyleEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public StyleEntity() {
    }
    public StyleEntity(StyleEnum num) {
    }

    public StyleEnum getName() {
        return name;
    }

    public StyleEntity setName(StyleEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StyleEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
