package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] animal = scan.nextLine().split("\\s+");

        while (!animal[0].equals("Beast!")) {

            if(animal.length != 1){
                System.out.println("Invalid input!");
                animal = scan.nextLine().split("\\s+");
                continue;
            }

            String[] token = scan.nextLine().split("\\s+");
            if (token.length != 3) {
                System.out.println("Invalid input!");
                animal = scan.nextLine().split("\\s+");
                continue;
            }
            String kindAnimal = token[0];
            int age = Integer.parseInt(token[1]);
            String gender = token[2];

            if (age < 0) {
                System.out.println("Invalid input!");
                animal = scan.nextLine().split("\\s+");
                continue;
            }
            switch (animal[0]) {
                case "Cat":
                    Cat cat = new Cat(kindAnimal, age, gender);
                    System.out.println(cat.toString() + cat.getGender());
                    System.out.println(cat.produceSound());
                    break;
                case "Dog":
                    Dog dog = new Dog(kindAnimal, age, gender);
                    System.out.println(dog.toString() + dog.getGender());
                    System.out.println(dog.produceSound());
                    break;
                case "Frog":
                    Frog frog = new Frog(kindAnimal, age, gender);
                    System.out.println(frog.toString() + frog.getGender());
                    System.out.println(frog.produceSound());
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(kindAnimal, age);
                    System.out.println(kitten.toString() + kitten.getGender());
                    System.out.println(kitten.produceSound());
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(kindAnimal, age);
                    System.out.println(tomcat.toString() + tomcat.getGender());
                    System.out.println(tomcat.produceSound());
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            animal = scan.nextLine().split("\\s+");

        }
    }
}
