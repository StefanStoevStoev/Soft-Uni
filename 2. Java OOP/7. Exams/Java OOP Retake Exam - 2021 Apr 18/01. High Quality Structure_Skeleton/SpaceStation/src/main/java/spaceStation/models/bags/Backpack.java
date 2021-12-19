package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;

public class Backpack implements Bag{
    private Collection<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    public void addItems(String items) {
        this.items.add(items);
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }
}
