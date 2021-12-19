package CardSuit;

public class Main {
    public static void main(String[] args) {

        Suits[] result = Suits.values();
        System.out.println("Card Suits:");
        for (Suits suits : result) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",suits.getValue(),suits.name());
        }
    }
}
