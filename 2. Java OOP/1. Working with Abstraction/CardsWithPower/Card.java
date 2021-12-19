package CardsWithPower;

public class Card {

    private Suits suits;
    private Rank rank;

    public Card(Suits suits, Rank rank) {
        this.suits = suits;
        this.rank = rank;
    }
    public int adding(Suits suits,Rank rank){
        return suits.getValue()+rank.getValue();
    }
}
