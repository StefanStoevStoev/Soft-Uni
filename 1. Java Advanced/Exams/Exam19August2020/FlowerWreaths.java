package Exam19August2020.FlowerWreaths;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputLilies = scan.nextLine().split(", ");
        String[] inputRoses = scan.nextLine().split(", ");

        int sumThrownFlowers = 0;
        ArrayDeque<Integer> lilies = new ArrayDeque<>(inputLilies.length);
        ArrayDeque<Integer> roses = new ArrayDeque<>(inputRoses.length);

        for (int i = 0; i < Math.max(inputLilies.length, inputRoses.length); i++) {
            if (inputLilies.length > i) {
                lilies.push(Integer.parseInt(inputLilies[i]));
            }
            if (inputRoses.length > i) {
                roses.offer(Integer.parseInt(inputRoses[i]));
            }
        }
        int sumOfFlowers = 0;
        int wreaths = 0;

        for (int k = 0; k < Math.min(inputLilies.length, inputRoses.length); k++) {
            int numberLilies = lilies.pop();
            int numberRoses = roses.poll();

            sumOfFlowers = numberLilies + numberRoses;

            if (sumOfFlowers == 15) {
                wreaths += 1;
            } else if (sumOfFlowers > 15) {
                while (sumOfFlowers > 15) {
                    numberLilies -= 2;
                    sumOfFlowers = numberLilies + numberRoses;
                    if (sumOfFlowers < 15) {
                        sumThrownFlowers += sumOfFlowers;
                        break;
                    } else if (sumOfFlowers == 15) {
                        wreaths += 1;
                    }
                }

            } else {
                sumThrownFlowers += sumOfFlowers;
            }
        }
        int wreathsAdd = sumThrownFlowers / 15;
        wreaths += wreathsAdd;
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            int diff = 5 - wreaths;
            System.out.printf("You didn't make it, you need %d wreaths more!", diff);
        }
    }
}
