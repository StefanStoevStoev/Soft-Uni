package Collection;

import javax.naming.InvalidNameException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidNameException {

        Scanner scan = new Scanner(System.in);

        String[] input = Arrays.stream(scan.nextLine().split("\\s"))
                .skip(1)
                .toArray(String[]::new);

        ListyIterator listNew = new ListyIterator(input);

        String token = scan.nextLine();

        while (!"END".equals(token)) {

            switch (token) {
                case "Move":
                    System.out.println(listNew.move());
                    break;
                case "HasNext":
                    System.out.println(listNew.hasNext());
                    break;
                case "Print":
                    try {
                        System.out.println(listNew.getCurrentElement());
                    } catch (UnsupportedOperationException ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "PrintAll":
                    listNew.forEach(e -> {
                        System.out.print(e + " ");
                    });
                    System.out.println();
                    break;
            }
            token = scan.nextLine();
        }
    }
}
