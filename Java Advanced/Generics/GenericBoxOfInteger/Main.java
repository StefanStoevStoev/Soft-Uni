package GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int h = 0; h < n; h++) {
            int token = Integer.parseInt(scan.nextLine());
            Box3 box = new Box3(token);

            System.out.println(box.toString());
        }
    }
}
