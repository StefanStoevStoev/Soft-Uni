import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Integer[] arrayInt = new Integer[input.length];

        for (int k = 0; k < input.length; k++) {
            arrayInt[k] = Integer.parseInt(input[k]);
        }

        Function<Integer[], Integer> function = array -> {
            Integer min = 1000000000;
            Integer index = 0;
            for (int k = 0; k < array.length; k++) {
                if (array[k] <= min) {
                    min = array[k];
                    index = k;
                }
            }
            return index;
        };
        System.out.println(function.apply(arrayInt));
    }
}
