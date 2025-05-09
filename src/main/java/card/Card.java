package card;

import deck.Deck;
import deck.DiscardDeck;
import player.Player;
import utility.KeyboardInput;


import java.util.Collection;

public abstract class Card {

    String RED = "\u001B[31m";
    String YELLOW = "\u001B[33m";
    String RESET = "\u001B[0m";
    String GREEN = "\u001B[32m";

    protected Player player;

    protected String name;

    protected KeyboardInput keyboard;






    public abstract void play(Player player, Deck deck, DiscardDeck discardDeck, Collection<Player> allPlayers);

    public String getName(){
        return name;
    }

}
