package GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Box4<Integer>> listString = new ArrayList<>();

        while (n-- > 0) {
            String token = scan.nextLine();
            Box4<Integer> box = new Box4<>(Integer.parseInt(token));
            listString.add(box);
        }
        int first = scan.nextInt();
        int second = scan.nextInt();
        
        swap(listString,first,second);

        for (Box4<Integer> stringBox : listString) {
            System.out.println(stringBox.toString());
        }
    }

    private static <T> void swap(List<Box4<T>> listString,int first, int second) {
        Box4<T> temp = listString.get(first);
        listString.set(first,listString.get(second));
        listString.set(second,temp);
    }
}
