package spaceStation.models.astronauts;

import spaceStation.models.bags.Bag;

public interface Astronaut {
    public String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
