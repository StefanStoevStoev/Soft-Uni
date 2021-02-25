package CardRank;

public class Main {
    public static void main(String[] args) {
        Rank[] result = Rank.values();
        System.out.println("Card Ranks:");
        for (Rank suits : result) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",suits.getValue(),suits.name());
        }
    }
}
