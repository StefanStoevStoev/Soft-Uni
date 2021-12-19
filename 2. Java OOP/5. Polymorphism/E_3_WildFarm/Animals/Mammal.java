package E_3_WildFarm.Animals;

import E_3_WildFarm.Food;

public abstract class Mammal extends Animal{
    private String livingRegion;

    protected Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }
}
