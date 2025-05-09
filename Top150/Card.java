package Top150;


public class Card {
    enum Suit {
        Heart, Club, Spade, Diamonds
    }
    enum Rank {
        A, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, J, Q, K
    }
    private Suit suit;
    private Rank rank;

    // constructor
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public void printCard(){
        System.out.println(rank + "" + suit);;
    }
}
