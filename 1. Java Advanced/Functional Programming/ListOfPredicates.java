import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        BiFunction<List<Integer>, Integer, Boolean> function = ((list, number)->{
            for (Integer integer : list) {
                if (number % integer != 0){
                    return false;
                }
            }
            return true;
        });

        for (int k = 1; k <= n; k++) {

            if (function.apply(numbers,k)){
                System.out.print(k +" ");
            }
        }
    }
}
