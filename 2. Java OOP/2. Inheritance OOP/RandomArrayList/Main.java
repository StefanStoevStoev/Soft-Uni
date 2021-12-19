package RandomArrayList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList(new Random());

        randomArrayList.add("Alice");
        randomArrayList.add("Bob");
        System.out.println(randomArrayList.getRandomElement());
    }
}
