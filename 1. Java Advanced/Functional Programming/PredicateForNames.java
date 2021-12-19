import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());
        String[] input = scan.nextLine().split("\\s+");

        Predicate<Integer> predicate = word -> word <= length;

        for (int k = 0; k < input.length; k++) {
            if (predicate.test(input[k].length())) {
                if (k < input.length - 1) {

                    System.out.println(input[k] + " ");
                } else {
                    System.out.println(input[k] + " ");

                }
            }

        }
    }
}
