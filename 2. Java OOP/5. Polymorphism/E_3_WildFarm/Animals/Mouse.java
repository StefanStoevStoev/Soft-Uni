package E_3_WildFarm.Animals;

import E_3_WildFarm.Food;
import E_3_WildFarm.Meat;

public class Mouse extends Mammal{


    public Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.eat(food);
    }

}
