import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");

        List<String> listNum = Arrays
                .stream(input)
                .collect(Collectors.toList());

        Predicate<String> isCapitalLetter = (word) -> Character.isUpperCase(word.charAt(0));

        List<String> upperCase = listNum.stream()
                .filter(isCapitalLetter)
                .collect(Collectors.toList());

        System.out.println(upperCase.size());
        upperCase.forEach(word -> System.out.println(word));

    }
}
