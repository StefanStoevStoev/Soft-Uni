package Exam2020Dec16;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputLiquids = scan.nextLine().split("\\s+");
        String[] inputIngredients = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> liquids = new ArrayDeque<>(inputLiquids.length);
        ArrayDeque<Integer> ingredients = new ArrayDeque<>(inputIngredients.length);

        for (int i = 0; i < Math.max(inputLiquids.length, inputIngredients.length); i++) {
            if (inputLiquids.length > i) {
                liquids.offer(Integer.parseInt(inputLiquids[i]));
            }
            if (inputIngredients.length > i) {
                ingredients.push(Integer.parseInt(inputIngredients[i]));
            }
        }
        int bread = 0;
        int cake = 0;
        int fruitPie = 0;
        int pastry = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int nextLiquid = liquids.peek();
            int nextIngredients = ingredients.peek();
            int sum = nextIngredients + nextLiquid;

            if (sum == 25) {
                bread++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 50) {
                cake++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 75) {
                pastry++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 100) {
                fruitPie++;
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                ingredients.pop();
                ingredients.push(nextIngredients+3);
            }
        }
        if (bread > 0 && pastry > 0 && fruitPie > 0 && cake > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            String dd = liquids.stream().map(Objects::toString).collect(Collectors.joining(", "));
            System.out.println(dd);
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");

            String dd = ingredients.stream().map(Objects::toString).collect(Collectors.joining(", "));
            System.out.println(dd);
        }

        System.out.printf("Bread: %d%n", bread);
        System.out.printf("Cake: %d%n", cake);
        System.out.printf("Fruit Pie: %d%n", fruitPie);
        System.out.printf("Pastry: %d", pastry);
    }
}
