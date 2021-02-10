import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        Integer[] arrayInt = new Integer[input.length];

        for (int k = 0; k < input.length; k++) {
            arrayInt[k] = Integer.parseInt(input[k]);
        }
        Function<Integer[],Integer> function = mini -> {
            int min = 1000000;
            for (Integer integer : mini) {
                if (integer<min){
                    min = integer;
                }
            }
            return min;
        };
        System.out.println(function.apply(arrayInt));
    }
}
