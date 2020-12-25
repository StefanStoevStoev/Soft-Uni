package Exam28June2020;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputEffects = scan.nextLine().split(", ");
        String[] inputCasing = scan.nextLine().split(", ");
        ArrayDeque<Integer> queueEffects = new ArrayDeque<>(inputEffects.length);
        ArrayDeque<Integer> stackCasing = new ArrayDeque<>(inputEffects.length);

        for (int k = 0; k < Math.max(inputEffects.length, inputCasing.length); k++) {
            if (inputEffects.length > k) {
                queueEffects.add(Integer.parseInt(inputEffects[k]));
            }
            if (inputCasing.length > k) {
                stackCasing.push(Integer.parseInt(inputCasing[k]));
            }
        }

        int bombDatura = 0;
        int bombCherry = 0;
        int bombSmoke = 0;
        int sum = 0;
        while (Math.min(queueEffects.size(), stackCasing.size()) > 0) {

            if (bombCherry > 2 && bombDatura > 2 && bombSmoke > 2) {
                break;
            }
            int effect = queueEffects.poll();
            int casing = stackCasing.pop();

            while (true) {

                sum = effect + casing;
                if (sum == 40) {
                    bombDatura += 1;
                    break;
                } else if (sum == 60) {

                    bombCherry += 1;
                    break;
                } else if (sum == 120) {
                    bombSmoke += 1;
                    break;
                } else {
                    casing -= 5;
                }
            }
        }
        if (bombCherry > 2 && bombDatura > 2 && bombSmoke > 2) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (queueEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            String ss = queueEffects.stream().map(Objects::toString).collect(Collectors.joining(", "));
            System.out.println(ss);
//            queueEffects.stream().map(Object::toString).collect(Collectors.joining(", "));
        }
        if (stackCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            String ss = stackCasing.stream().map(Objects::toString).collect(Collectors.joining(", "));
            System.out.println(ss);
//            stackCasing.stream().map(Object::toString).collect(Collectors.joining(", "));
        }
        System.out.printf("Cherry Bombs: %d%n", bombCherry);
        System.out.printf("Datura Bombs: %d%n", bombDatura);
        System.out.printf("Smoke Decoy Bombs: %d%n", bombSmoke);
    }
}
