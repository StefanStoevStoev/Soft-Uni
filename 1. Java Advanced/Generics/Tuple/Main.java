package Tuple;

import java.util.Scanner;

class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokensName = scan.nextLine().split("\\s+");
        String name = tokensName[0] + " " + tokensName[1];
        String adress = tokensName[2];
        Tuple<String, String> person = new Tuple<>(name, adress);

        String[] tokenBeer = scan.nextLine().split("\\s+");
        String name2 = tokenBeer[0];
        String beer = tokenBeer[1];
        Tuple<String, String> nameBeer = new Tuple<>(name2, beer);

        String[] tokenInt = scan.nextLine().split("\\s+");
        int integ = Integer.parseInt(tokenInt[0]);
        Double dobl = Double.parseDouble(tokenInt[1]);
        Tuple<Integer, Double> intDoubl = new Tuple<>(integ, dobl);

        System.out.println(person.toString());
        System.out.println(nameBeer.toString());
        System.out.println(intDoubl.toString());
    }
}
