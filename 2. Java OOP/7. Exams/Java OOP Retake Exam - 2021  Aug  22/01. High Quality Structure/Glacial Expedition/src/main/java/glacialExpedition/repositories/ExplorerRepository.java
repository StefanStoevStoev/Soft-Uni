package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ExplorerRepository implements Repository<Explorer>{

    private Map<String,Explorer> explorers;

    public ExplorerRepository() {
        this.explorers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return explorers.values().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void add(Explorer entity) {
        explorers.putIfAbsent(entity.getName(),entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        boolean exist = explorers.containsKey(entity.getName());
        explorers.remove(entity.getName());
        return exist;
    }

    @Override
    public Explorer byName(String name) {

        if (!explorers.containsKey(name)){
            return null;
        }
        return explorers.get(name);
    }
}
