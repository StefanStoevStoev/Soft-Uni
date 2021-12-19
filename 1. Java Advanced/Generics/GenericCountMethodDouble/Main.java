package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<GenericBox6<Double>> listBox = new ArrayList<>();

        while (n-- > 0) {
            Double input = Double.parseDouble(scan.nextLine());
            listBox.add(new GenericBox6<>(input));
        }

        String compare = scan.nextLine();
        int count = consist(listBox, new GenericBox6<>(Double.parseDouble(compare)));
        System.out.println(count);
    }

    private static <T extends Comparable<T>> int consist(List<GenericBox6<T>> listBox, GenericBox6<T> compare) {
        int count = 0;

        for (GenericBox6<T> box : listBox) {
            if (box.compareTo(compare) > 0) {
                count++;
            }
        }
        return count;
    }
}
