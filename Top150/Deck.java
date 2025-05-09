package Top150;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class Deck {
    private List<Card> cards;
    public Deck(){
        cards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()){
            for (Card.Rank rank : Card.Rank.values()){
                cards.add(new Card(suit,rank));
            }
        }
    }

    //print cards
    public void printDeck(){
        for(Card card:cards){
            card.printCard();
        }
    }

    public void shuffle(){
        Random r = new Random();
        for (int i = 0 ; i<cards.size(); i++){
            Card tmp = cards.remove(0);
            cards.add(r.nextInt(cards.size()),tmp);
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        //deck.printDeck();
        deck.shuffle();

        deck.printDeck();
    }

}
