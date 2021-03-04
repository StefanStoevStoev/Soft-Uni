package animals;

public class Dog extends Animal {

    private final static String SOUND = "Woof!";

    public Dog(String name, int age, String gender) {
        super(name, age, SOUND, gender);
        super.produceSound();
    }
}
