package Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Lake lakeEven = new Lake(
                Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray());

        StringBuilder builder = new StringBuilder();

        for (Integer integer : (Iterable<Integer>) lakeEven) {
            builder.append(integer).append(", ");
        }

        String result = builder.toString();
        System.out.println(result.substring(0,result.lastIndexOf(",")));
    }
}
