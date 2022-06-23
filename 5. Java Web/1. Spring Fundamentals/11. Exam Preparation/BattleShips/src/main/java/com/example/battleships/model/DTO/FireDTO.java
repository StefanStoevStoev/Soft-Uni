package com.example.battleships.model.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class FireDTO {

    @NotNull
    @Positive
    private Long attackerId;

    @NotNull
    @Positive
    private Long defenderId;

    public FireDTO() {
    }

    public Long getAttackerId() {
        return attackerId;
    }

    public FireDTO setAttackerId(Long attackerId) {
        this.attackerId = attackerId;
        return this;
    }

    public Long getDefenderId() {
        return defenderId;
    }

    public FireDTO setDefenderId(Long defenderId) {
        this.defenderId = defenderId;
        return this;
    }
}
