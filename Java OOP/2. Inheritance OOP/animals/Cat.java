package animals;

public class Cat extends Animal {

    private static final String SOUND_CAT = "Meow meow";

    public Cat(String name, int age, String gender) {
        super(name, age, SOUND_CAT, gender);
        super.produceSound();
    }
}
