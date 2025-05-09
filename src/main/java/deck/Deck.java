package deck;

import card.*;
import utility.KeyboardInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Deck {

    private ArrayList<Card> cards;

    private ListIterator<Card> iterator;

    private KeyboardInput keyboard;

    public Deck(KeyboardInput keyboard){

        this.keyboard = keyboard;

        cards = new ArrayList<>();

        iterator = cards.listIterator();

        for(int i = 1; i <=8; i++){
            Brown card = new Beer();
            cards.add(card);
        }

        for(int i = 1; i <= 30; i++){
            Brown card = new Bang(keyboard);
            cards.add(card);
        }

        for(int i = 1; i <= 15; i++){
            Brown card = new Missed();
            cards.add(card);
        }

        for(int i = 1; i <= 4; i++){
            Brown card = new Stagecoach();
            cards.add(card);
        }

        for(int i = 1; i <= 2; i++){
            Blue card = new Barrel();
            cards.add(card);
        }

        for(int i = 1; i <= 3; i++){
            Blue card = new Prison();
            cards.add(card);
        }

        for(int i = 1; i <= 2; i++){
            Brown card = new Indians();
            cards.add(card);
        }

        Blue card = new Dynamite();
        cards.add(card);


        Collections.shuffle(cards);








    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ListIterator<Card> getIterator() {
        return iterator;
    }



    public Card drawCard(){

        return cards.remove(iterator.nextIndex());

    }

}