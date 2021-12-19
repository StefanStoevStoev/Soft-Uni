import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(", ");

        List<Integer> listNum = Arrays
                .stream(tokens)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Predicate<Integer> isEven = (number) -> number %2==0;

        String output = listNum.stream()
                .filter(isEven)
                .map(number -> number.toString())
                .collect(Collectors.joining(", "));
        String sorted = listNum.stream()
                .filter(isEven)
                .sorted()
                .map(number -> number.toString())
                .collect(Collectors.joining(", "));
        System.out.println(output);
        System.out.println(sorted);
    }
}
