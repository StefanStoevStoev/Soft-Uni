package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.*;
import java.util.stream.Collectors;

public class StateRepository implements Repository<State>{

    private Set<State> states;

    public StateRepository() {
        this.states = new HashSet<>();
    }

    @Override
    public Collection<State> getCollection() {
        return states.stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void add(State entity) {
        states.add(entity);
    }

    @Override
    public boolean remove(State entity) {
        boolean exist = states.contains(entity);
        if (exist){
            states.remove(entity);
        }
        return exist;
    }

    @Override
    public State byName(String name) {
        return states.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
