import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");
        int[] array = new int[tokens.length];

        for (int k = 0; k < tokens.length; k++) {
            array[k] = Integer.parseInt(tokens[k]);
        }

        int sum = sumOfArray(array, 0);
        System.out.println(sum);
    }

    private static int sumOfArray(int[] array, int i) {
        if (array.length > i) {
            int currentElement = array[i];
            int sumSoFar = sumOfArray(array, i + 1);
            return currentElement + sumSoFar;
        }
        return 0;
    }

}
