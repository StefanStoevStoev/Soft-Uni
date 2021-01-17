package Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokensName = scan.nextLine().split("\\s+");
        String name = tokensName[0] + " " + tokensName[1];
        String district = tokensName[2];
        String city = tokensName[3];
        Threeuple<String, String, String> person = new Threeuple<>(name, district,city);

        String[] tokenBeer = scan.nextLine().split("\\s+");
        String name2 = tokenBeer[0];
        int litres = Integer.parseInt(tokenBeer[1]);
        String drunk = tokenBeer[2];
        boolean sdsd = Threeuple.drunkOrNot(drunk);
        Threeuple<String, Integer, Boolean> nameBeer = new Threeuple<>(name2, litres,sdsd);

        String[] tokenInt = scan.nextLine().split("\\s+");
        String name3 = tokenInt[0];
        String bank = tokenInt[2];
        Double dobl = Double.parseDouble(tokenInt[1]);
        Threeuple<String, Double,String> intDoubl = new Threeuple<>(name3, dobl,bank);

        System.out.println(person.toString());
        System.out.println(nameBeer.toString());
        System.out.println(intDoubl.toString());
    }
}
