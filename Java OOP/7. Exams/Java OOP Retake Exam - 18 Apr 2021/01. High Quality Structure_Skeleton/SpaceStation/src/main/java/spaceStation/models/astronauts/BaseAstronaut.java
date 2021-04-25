package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import static spaceStation.common.ExceptionMessages.*;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    public void setBag(Bag bag){
        this.bag = bag;
    }

    public void setName(String name) {
        if (name == null || name.equals(" ")) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setOxygen(double oxygen) {
        if (this.oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean canBreath() {
            return this.oxygen > 0;

    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        if (this.oxygen > 0) {
            this.oxygen -= 10;
            if (oxygen < 0) {
                this.oxygen = 0;
            }
        }
    }
}
