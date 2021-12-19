package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        Treasure treasure = new Treasure(scanner.nextLine().split("\\s+"));

        Bag bag = new Bag(capacity);

        for (var pair : treasure) {
            String first = pair.getFirst();
            Long value = pair.getSecond();

            String type = null;
            if (first.length() == 3) {
                type = "Cash";
            } else if (first.toLowerCase().endsWith("gem")) {
                type = "Gem";
            } else if (first.toLowerCase().equals("gold")) {
                type = "Gold";
            }
            if (bag.hasRoomFor(value) && type != null) {

            }
        }

    }
}