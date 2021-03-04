package animals;

public class Frog extends Animal {

    private final static String SOUND_FROG = "Ribbit";

    public Frog(String name, int age, String gender) {
        super(name, age, SOUND_FROG, gender);
        super.produceSound();
    }
}
