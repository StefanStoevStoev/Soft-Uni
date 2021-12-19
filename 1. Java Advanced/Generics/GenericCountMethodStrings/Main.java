package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<GenericBox5<String>> listBox = new ArrayList<>();

        while (n-- > 0) {
            String input = scan.nextLine();
            listBox.add(new GenericBox5<>(input));
        }
        String compare = scan.nextLine();
        int count = consist(listBox, new GenericBox5<>(compare));
        System.out.println(count);
    }

    private static <T extends Comparable<T>> int consist(List<GenericBox5<T>> listBox, GenericBox5<T> compare) {
        int count = 0;

        for (GenericBox5<T> box : listBox) {
            if (box.getValue().compareTo(compare.getValue()) > 0) {
                count++;
            }
        }
        return count;
    }
}
