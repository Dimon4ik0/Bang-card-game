package deck;

import card.Card;

import java.util.ArrayList;

public class DiscardDeck {

    private ArrayList<Card> discardDeck;

    public DiscardDeck(){

        discardDeck = new ArrayList<>();
    }


    public void discardCard(Card card){
        discardDeck.add(card);
    }

    public ArrayList<Card> getDiscardDeck() {
        return discardDeck;
    }
}
