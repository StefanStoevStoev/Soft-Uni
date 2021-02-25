package CardSuit;

public enum Suits {
    CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);
//    0; Name value: CLUBS
//Ordinal value: 1; Name value: DIAMONDS
//Ordinal value: 2; Name value: HEARTS
//Ordinal value: 3; Name value: SPADES

    private int value;

    Suits(int value){
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}
