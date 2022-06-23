package com.example.battleships.model.DTO;
import com.example.battleships.model.entity.UserEntity;
import com.example.battleships.model.entity.enums.EnumCategory;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipDTO {

    @Size(min = 2, max = 10)
    private String name;

    @NotNull(message = "Power cannot be empty.")
    @Positive
    private int power;

    @NotNull(message = "Health cannot be empty.")
    @Positive
    private int health;

    @NotNull(message = "Created cannot be empty.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;
//    @NotNull(message = "Category cannot be empty.")
//    @Enumerated
    private EnumCategory category;
    private UserEntity user;

    public ShipDTO() {
    }


    public String getName() {
        return name;
    }

    public ShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getPower() {
        return power;
    }

    public ShipDTO setPower(int power) {
        this.power = power;
        return this;
    }

    public int getHealth() {
        return health;
    }

    public ShipDTO setHealth(int health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public EnumCategory getCategory() {
        return category;
    }

    public ShipDTO setCategory(EnumCategory category) {
        this.category = category;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ShipDTO setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
