package com.example.irrigation2.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sprinkler_user")
public class SprinklerNumbers {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;

    @ManyToOne
    @JoinColumn(name = "sprinkler_id")
    DripEntity sprinkler;

    LocalDateTime buyDate;

    int numbers;

    public SprinklerNumbers() {
    }

    public Long getId() {
        return id;
    }

    public SprinklerNumbers setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public SprinklerNumbers setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public DripEntity getSprinkler() {
        return sprinkler;
    }

    public SprinklerNumbers setSprinkler(DripEntity sprinkler) {
        this.sprinkler = sprinkler;
        return this;
    }

    public LocalDateTime getBuyDate() {
        return buyDate;
    }

    public SprinklerNumbers setBuyDate(LocalDateTime buyDate) {
        this.buyDate = buyDate;
        return this;
    }

    public int getNumbers() {
        return numbers;
    }

    public SprinklerNumbers setNumbers(int numbers) {
        this.numbers = numbers;
        return this;
    }
}
