package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;

public class GunRepository<G> implements Repository<Gun> {
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.models;
    }

    @Override
    public void add(Gun model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(Gun model) {

        return models.remove(model);
    }

    @Override
    public Gun find(String name) {

        return models.stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);
    }
}
