package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class AstronautRepository<A> implements Repository<Astronaut>{

    private Map<String, Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(astronauts.values());
    }

    @Override
    public void add(Astronaut model) {

        this.astronauts.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Astronaut model) {
        if (this.astronauts.containsKey(model.getName())){
            this.astronauts.remove(model.getName());
            return true;
        }
        return false;
    }

    @Override
    public Astronaut findByName(String name) {
        if (this.astronauts.containsKey(name)){
            return this.astronauts.get(name);
        }
        return null;
    }
}
