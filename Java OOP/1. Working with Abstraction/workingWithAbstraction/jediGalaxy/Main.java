package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimestions = readPositions(scanner.nextLine());

        Movement jediMovement = new JediMovement();
        Movement sithMovement = new SithMovement();

        Galaxy galaxy = new Galaxy(new Filed(dimestions[0], dimestions[1]),jediMovement,sithMovement);

        String position = scanner.nextLine();
        long starsPower = 0;

        while (!position.equals("Let the Force be with you")) {


            int[] jediPosition = readPositions(position);
            int[] sithPosition = readPositions(scanner.nextLine());

            int rowSith = sithPosition[0];
            int colSith = sithPosition[1];

            galaxy.moveSith(rowSith,colSith);

            int rowJedi = jediPosition[0];
            int colJedi = jediPosition[1];

            starsPower += galaxy.moveJedi(rowJedi,colJedi);

            galaxy.moveJedi(rowJedi,colJedi);
            position = scanner.nextLine();
        }

        System.out.println(starsPower);


    }



    private static int[] readPositions(String position) {
        return Arrays.stream(position.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
