import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        List<String> listNum = Arrays
                .stream(input)
                .collect(Collectors.toList());

        UnaryOperator<Double> addVAT = (dbl) -> dbl*1.2;
        Function<Double,String> toStringN = (dbl) -> String.format("%.2f",dbl);
        Function<Double, String> finalFunc = addVAT.andThen(toStringN);

        System.out.println("Prices with VAT:");

        listNum.stream()
                .map(str -> Double.parseDouble(str))
                .map(finalFunc)
                .forEach(str -> System.out.println(str));
    }
}
