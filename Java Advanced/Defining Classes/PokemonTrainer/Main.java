package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Trainer> mapTrainer = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!"Tournament".equals(input)) {

            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            mapTrainer.putIfAbsent(trainerName, new Trainer());
            mapTrainer.get(trainerName).addPokemon(pokemon);

            input = scan.nextLine();
        }
        String inputNext = scan.nextLine();
        while (!"End".equals(inputNext)) {

            for (Map.Entry<String, Trainer> stringTrainerEntry : mapTrainer.entrySet()) {

                for (Pokemon pokemon : stringTrainerEntry.getValue().getPokemon()) {
                    if (pokemon.getElement().contains(inputNext)) {
                        stringTrainerEntry.getValue().setNumberOfBadges();
                        break;
                    } else {
                        if (pokemon.getHealth() < 0) {
                            stringTrainerEntry.getValue().missingPokemonPenalty();
                        } else {
                            pokemon.setHealth();
                        }

                    }
                }
            }
            inputNext = scan.nextLine();
        }
        mapTrainer.entrySet().stream()
                .sorted((e, f) -> (f.getValue().getNumberOfBadges() - e.getValue().getNumberOfBadges()))
                .forEach(e -> {
                    System.out.println(e.getKey() + " " + e.getValue().getNumberOfBadges() + " " + e.getValue().pokeCollectionSize());
                });
    }
}
