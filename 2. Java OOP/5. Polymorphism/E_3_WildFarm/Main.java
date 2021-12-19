package E_3_WildFarm;

import E_3_WildFarm.Animals.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        List<Animal> animalList = new ArrayList<>();

        while(!line.equals("End")){

            Animal animal = createAnimal(line.split("\\s+"));

            String oddLine = scan.nextLine();
            Food food = createFood(oddLine.split("\\s+"));

            animal.makeSound();

            try{
                animal.eat(food);
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            animalList.add(animal);

            line = scan.nextLine();
        }
        for (Animal animal : animalList) {
            System.out.println(animal.toString());
        }
    }

    private static Food createFood(String[] tokens) {
        int quantity = Integer.parseInt(tokens[1]);
        return tokens[0].equals("Meat") ? new Meat(quantity) : new Vegetable(quantity);
    }

    private static Animal createAnimal(String[] tokens) {
        switch (tokens[0]){
            case "Cat":
                return new Cat("Cat", tokens[1],Double.parseDouble(tokens[2]),tokens[3],tokens[4]);
            case "Tiger":
                return new Tiger("Tiger", tokens[1],Double.parseDouble(tokens[2]),tokens[3]);
            case "Zebra":
                return new Zebra("Zebra", tokens[1],Double.parseDouble(tokens[2]),tokens[3]);
            case "Mouse":
                return new Mouse("Mouse", tokens[1],Double.parseDouble(tokens[2]),tokens[3]);
            default:
                throw new IllegalStateException("Unknown animal type " + tokens[0]);
        }
    }

}
