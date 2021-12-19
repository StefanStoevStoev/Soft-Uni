package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut{
    private final static double OXYGEN = 90;
    private String name;

    public Meteorologist(String name) {
        super(name, OXYGEN);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
