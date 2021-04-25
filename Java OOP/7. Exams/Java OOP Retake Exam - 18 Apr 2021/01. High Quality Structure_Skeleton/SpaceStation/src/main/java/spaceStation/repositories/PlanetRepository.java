package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository<P> implements Repository<Planet>{
    private Map<String, Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection getModels() {
        return Collections.unmodifiableCollection(planets.values());
    }

    @Override
    public void add(Planet model) {

        this.planets.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Planet model) {
        if (this.planets.containsKey(model.getName())){
            this.planets.remove(model.getName());
            return true;
        }
        return false;
    }

    @Override
    public Planet findByName(String name) {
        if (this.planets.containsKey(name)){
            return this.planets.get(name);
        }
        return null;
    }
}
