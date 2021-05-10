package viceCity.models.players;

public class MainPlayer extends BasePlayer {

    private static final int LIFE_POINTS = 100;
    private final static String name = "Tommy Vercetti";

    public MainPlayer() {
        super(name, LIFE_POINTS);
    }
}
