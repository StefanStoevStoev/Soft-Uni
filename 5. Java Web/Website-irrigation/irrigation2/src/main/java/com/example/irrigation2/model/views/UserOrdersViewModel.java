package com.example.irrigation2.model.views;

import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.PumpEntity;
import com.example.irrigation2.model.entity.SprinklerEntity;

import java.util.List;

public class UserOrdersViewModel {

    private List<DripEntity> drips;
    private List<SprinklerEntity> sprinklers;
    private List<PumpEntity> pumps;

    public UserOrdersViewModel() {
    }

    public List<DripEntity> getDrips() {
        return drips;
    }

    public UserOrdersViewModel setDrips(List<DripEntity> drips) {
        this.drips = drips;
        return this;
    }

    public List<SprinklerEntity> getSprinklers() {
        return sprinklers;
    }

    public UserOrdersViewModel setSprinklers(List<SprinklerEntity> sprinklers) {
        this.sprinklers = sprinklers;
        return this;
    }

    public List<PumpEntity> getPumps() {
        return pumps;
    }

    public UserOrdersViewModel setPumps(List<PumpEntity> pumps) {
        this.pumps = pumps;
        return this;
    }
}
