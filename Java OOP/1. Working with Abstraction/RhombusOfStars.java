import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int k = 0; k < n; k++) {
            printRow(k,n);
        }
        for (int k = n-2; k >= 0; k--) {
            printRow(k,n);
        }
    }

    private static void printRow(int k, int n) {
        for (int i = n - k; i > 1; i--) {
            System.out.print(" ");
        }
        for (int i = 0; i <= k; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
