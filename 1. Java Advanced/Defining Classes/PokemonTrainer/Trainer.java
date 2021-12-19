package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {

    private int numberOfBadges;
    private List<Pokemon> pokemons;
    private UnaryOperator<Pokemon> damagePokemon = pokemon ->
            new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth() - 10);

    public Trainer() {

        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void setNumberOfBadges() {
        this.numberOfBadges++;
    }

    public List<Pokemon> getPokemon() {

        return new ArrayList<>(this.pokemons);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public int pokeCollectionSize(){
        return this.pokemons.size();
    }

    public void missingPokemonPenalty() {
        this.pokemons = this.pokemons
                .stream()
                .map(damagePokemon)
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }
}
