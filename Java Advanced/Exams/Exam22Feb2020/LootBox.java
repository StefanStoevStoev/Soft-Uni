package Exam22Feb2020;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputQueue = scan.nextLine().split("\\s+");
        String[] inputStack = scan.nextLine().split("\\s+");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int k = 0; k < Math.max(inputQueue.length, inputStack.length); k++) {
            if (inputStack.length > k) {
                stack.push(Integer.parseInt(inputStack[k]));
            }
            if (inputQueue.length > k) {
                queue.offer(Integer.parseInt(inputQueue[k]));
            }
        }

        int collection = 0;

        while (!stack.isEmpty() && !queue.isEmpty()) {

            int firstBox = stack.peek();
            int secondBox = queue.peek();

            int sum = firstBox + secondBox;

            if (sum % 2 == 0) {
                collection += sum;
                stack.pop();
                queue.poll();
            } else {
                queue.offer(stack.pop());
            }
        }
        if (queue.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if (stack.isEmpty()){
            System.out.println("Second lootbox is empty");
        }
        if(collection>100){
            System.out.printf("Your loot was epic! Value: %d%n",collection);
        }else {
            System.out.printf("Your loot was poor... Value: %d%n",collection);

        }
    }
}
