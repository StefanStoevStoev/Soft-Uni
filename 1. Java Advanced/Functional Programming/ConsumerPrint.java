import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
            Consumer<String> print = sum -> System.out.println(sum);

        for (String s : input) {

            print.accept(s);
        }
    }
}
