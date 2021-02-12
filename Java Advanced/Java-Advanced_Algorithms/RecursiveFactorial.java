import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        System.out.println(takeFactorial(num));

    }
    private static int takeFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * takeFactorial(num-1);
    }
}
