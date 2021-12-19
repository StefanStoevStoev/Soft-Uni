package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rank = scan.nextLine();
        String suits = scan.nextLine();

        Suits suitsValue = Suits.valueOf(suits);
        Rank rankValue = Rank.valueOf(rank);

        Card card = new Card(suitsValue,rankValue);
        int power = card.adding(suitsValue,rankValue);

        System.out.printf("Card name: %s of %s; Card power: %d",rank,suits,power);
    }
}
