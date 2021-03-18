package E_3_WildFarm.Animals;

import E_3_WildFarm.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private String livingRegion;
    private int foodEaten;

    protected Animal(String animalType,String animalName, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;

    }

    public abstract void makeSound();
    public void eat(Food food){
        this.foodEaten += food.getQuantity();
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.animalType,
                this.animalName,
                format.format(this.animalWeight),
                this.livingRegion,
                this.foodEaten);
    }
}
