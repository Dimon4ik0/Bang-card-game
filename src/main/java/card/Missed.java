package card;

import deck.Deck;
import deck.DiscardDeck;
import player.Player;

import java.util.Collection;

public class Missed extends Brown{


    public Missed(){
        this.name = "Missed";
    }

    @Override
    public void play(Player player, Deck deck, DiscardDeck discardDeck, Collection<Player> allPlayers){

        System.out.println("This card is used for defence only");

    }

}
