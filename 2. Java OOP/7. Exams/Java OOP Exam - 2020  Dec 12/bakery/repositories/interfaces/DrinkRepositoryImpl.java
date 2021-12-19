package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {

    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Drink drink) {
        models.add(drink);
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        Drink drink = null;
        for (Drink model : models) {
            if (model.getName().contains(drinkName)&&model.getBrand().contains(drinkBrand)){
                drink = model;
            }
        }
        return drink;
    }
}
