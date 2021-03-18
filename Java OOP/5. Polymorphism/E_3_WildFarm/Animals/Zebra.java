package E_3_WildFarm.Animals;

import E_3_WildFarm.Animals.Mammal;
import E_3_WildFarm.Food;
import E_3_WildFarm.Meat;

public class Zebra extends Mammal {


    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }
}
