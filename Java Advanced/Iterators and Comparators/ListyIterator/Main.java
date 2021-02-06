package ListyIterator;

import javax.naming.InvalidNameException;
import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                    try{
                        System.out.println(listNew.getCurrentElement());
                    }catch (UnsupportedOperationException ex){
                        System.out.println(ex.getMessage());
                    }

                    break;
            }
            token = scan.nextLine();
        }
    }
}
