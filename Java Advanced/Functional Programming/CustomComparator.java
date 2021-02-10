import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        List<Integer> arrayEven = new ArrayList<>();
        List<Integer> arrayOdd = new ArrayList<>();

        for (int k = 0; k < input.length; k++) {

            Integer token = Integer.parseInt(input[k]);

            if (token % 2 == 0) {
                arrayEven.add(token);
            } else {
                arrayOdd.add(token);
            }
        }
        arrayEven.stream()
                .sorted((e1, e2) -> e1.compareTo(e2))
                .forEach(e -> System.out.print(e + " "));
        arrayOdd.stream()
                .sorted((e1, e2) -> e1.compareTo(e2))
                .forEach(e -> System.out.print(e + " "));

    }
}
