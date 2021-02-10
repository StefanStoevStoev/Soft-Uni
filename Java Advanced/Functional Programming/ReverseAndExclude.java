import java.util.Scanner;
import java.util.function.Function;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        Integer[] arrayInt = new Integer[input.length];

        for (int k = 0; k < input.length; k++) {
            arrayInt[k] = Integer.parseInt(input[k]);
        }
        int number = Integer.parseInt(scan.nextLine());

        Function<Integer, Integer> function = sum -> sum % number;

        for (int h = arrayInt.length - 1; h >= 0; h--) {
            if (function.apply(arrayInt[h]) != 0) {
                if (h != 0) {

                    System.out.print(arrayInt[h] + " ");
                } else {
                    System.out.print(arrayInt[h]);

                }
            }
        }
    }
}
