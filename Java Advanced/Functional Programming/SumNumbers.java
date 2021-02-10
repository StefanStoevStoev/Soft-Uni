import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(", ");

        List<String> listNum = Arrays
                .stream(tokens)
                .collect(Collectors.toList());

        ToIntFunction<String> input = str -> Integer.valueOf(str);
        int sum = listNum
                .stream()
                .mapToInt((ToIntFunction<? super String>) input)
                .sum();

        System.out.println("Count = " + listNum.size());
        System.out.println("Sum = " + sum);
    }
}
