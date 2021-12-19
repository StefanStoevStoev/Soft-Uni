package bakery.repositories.interfaces;


import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> model;

    public TableRepositoryImpl() {
        this.model = new ArrayList<>();
    }

    @Override
    public Table getByNumber(int number) {
        return this.model.stream().filter(f -> f.getTableNumber() == number).findFirst().orElse(null);
    }

    @Override
    public Collection<Table> getAll() {
        return Collections.unmodifiableCollection(this.model);
    }

    @Override
    public void add(Table table) {
        this.model.add(table);
    }
}
