package E_ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double length = scan.nextDouble();
        double width = scan.nextDouble();
        double height = scan.nextDouble();

        try {
            Box box = new Box(length, width, height);
            System.out.print(box);

        } catch (IllegalArgumentException idnored) {
            System.out.println(idnored.getMessage());
        }
    }
}
