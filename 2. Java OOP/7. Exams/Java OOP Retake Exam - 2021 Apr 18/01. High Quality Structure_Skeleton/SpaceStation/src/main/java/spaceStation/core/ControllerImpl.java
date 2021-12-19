package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository<Astronaut> austronauts;
    private PlanetRepository<Planet> planets;
    private Mission mission;
    private int exploredPlanetsCount = 0;

    public ControllerImpl() {
        this.austronauts = new AstronautRepository<>();
        this.planets = new PlanetRepository<>();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {

        Astronaut astronaut;

        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);

        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        austronauts.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {////////////
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        planets.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = austronauts.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        austronauts.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);

    }

    @Override
    public String explorePlanet(String planetName) {
        int deadAstronauts = 0;
        List<Astronaut> suitableAstronauts = austronauts
                .getModels()
                .stream()
                .filter(p->p.getOxygen()>60)
                .collect(Collectors.toList());

        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = planets.findByName(planetName);
        mission.explore(planet, suitableAstronauts);
        exploredPlanetsCount++;

        for (Astronaut astronaut : suitableAstronauts) {
            if (!astronaut.canBreath()) {
                deadAstronauts++;
            }
        }

        return String.format
                (PLANET_EXPLORED
                        , planetName
                        , deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d planets were explored!",exploredPlanetsCount));
        sb.append(System.lineSeparator());
        sb.append("Astronauts info:");
        sb.append(System.lineSeparator());
        this.austronauts.getModels().stream()
                .forEach(austr ->
                        sb.append(String.format("Name: %s",austr.getName()))
                                .append(System.lineSeparator())
                                .append(String.format("Oxygen: %.0f",austr.getOxygen()))
                                .append(System.lineSeparator())
                                .append(String.format("Bag items: %s"
                                        ,austr.getBag().getItems().size() == 0 ? "none" : String.join(", ", austr.getBag().getItems())))
                                .append(System.lineSeparator())
                );

        return sb.toString().trim();
    }
}
