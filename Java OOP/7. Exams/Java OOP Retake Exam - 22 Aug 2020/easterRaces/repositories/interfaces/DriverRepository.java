package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.Driver;

import java.util.*;

public class DriverRepository<D> implements Repository<Driver> {///////////////
    private Map<String,Driver> models;

    public DriverRepository() {
        this.models = new LinkedHashMap<>();
    }//////////

    @Override
    public Driver getByName(String name) {/////////////
        Driver driver = null;
        if(this.models.containsKey(name)){
            driver = models.get(name);
        }
        return driver;
    }

    @Override
    public Collection<Driver> getAll() {////////////////
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Driver model) {////////////
        this.models.putIfAbsent(model.getName(),model);
    }

    @Override
    public boolean remove(Driver model) {//////////////////
        Driver remove = models.remove(model.getName());
        return remove != null;
    }
}
