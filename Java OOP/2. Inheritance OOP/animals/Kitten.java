package animals;

public class Kitten extends Cat {

    private static final String SOUND_KITTEN = "Meow";
    private static final String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, SOUND_KITTEN);
        super.produceSound();
    }
    @Override
    public String getGender() {
        return GENDER;
    }
}
