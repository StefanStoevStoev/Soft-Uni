import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split(" ");
        int firstNum = Integer.parseInt(tokens[0]);
        int secondNum = Integer.parseInt(tokens[1]);

        Predicate<Integer> predicateOdd = number -> number % 2 != 0;
        Predicate<Integer> predicateEven = number -> number % 2 == 0;

        String evenOrOdd = scan.nextLine();

        switch (evenOrOdd){
            case "odd":
                predicatePrint(firstNum,secondNum,predicateOdd);
                break;
            case "even":
                predicatePrint(firstNum,secondNum,predicateEven);
                break;
        }
    }
    private static void predicatePrint(int firstNum, int secondNum, Predicate<Integer> predicate) {
        List<Integer> list = new ArrayList<>();

        for (int k = firstNum; k <= secondNum; k++) {
            list.add(k);
        }
        List<Integer> otherList = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        System.out.println(otherList.toString().replaceAll("[\\[\\],]",""));
    }
}
