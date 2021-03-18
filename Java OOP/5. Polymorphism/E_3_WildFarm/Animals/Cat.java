package E_3_WildFarm.Animals;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }
    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        builder.insert(builder.indexOf(",") + 1, " " + this.breed + ",");
        return builder.toString();
    }
}
