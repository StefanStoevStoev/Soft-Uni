import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        Integer[] arrayInt = new Integer[input.length];

        for (int k = 0; k < input.length; k++) {
            arrayInt[k] = Integer.parseInt(input[k]);
        }

        Function<Integer, Integer> functionAdd = add -> add + 1;
        Function<Integer, Integer> functionMultiply = mult -> mult * 2;
        Function<Integer, Integer> functionSubstr = sub -> sub - 1;
        Consumer<Integer> print = printt -> System.out.print(printt + " ");

        String token = scan.nextLine();

        while (!"end".equals(token)) {

            switch (token) {
                case "add":
                    arrayInt = functionAll(arrayInt, functionAdd);
                    break;
                case "multiply":
                    arrayInt = functionAll(arrayInt, functionMultiply);
                    break;
                case "subtract":
                    arrayInt = functionAll(arrayInt, functionSubstr);
                    break;
                case "print":
                    for (int i = 0; i < arrayInt.length; i++) {
                        if (i < arrayInt.length - 1) {
                            print.accept(arrayInt[i]);
                        } else {
                            System.out.println(arrayInt[i]);
                        }
                    }
                    break;
            }
            token = scan.nextLine();
        }
    }

    private static Integer[] functionAll(Integer[] arrayInt, Function<Integer, Integer> functionAdd) {
        Integer[] newNumbers = new Integer[arrayInt.length];
        for (int k = 0; k < arrayInt.length; k++) {
            newNumbers[k] = functionAdd.apply(arrayInt[k]);
        }
        return newNumbers;
    }
}
