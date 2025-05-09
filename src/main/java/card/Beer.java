package card;

import deck.Deck;
import deck.DiscardDeck;
import player.Player;
import java.util.Collection;


public class Beer extends Brown {

    String GREEN = "\u001B[32m";
    String RESET = "\u001B[0m";

    public Beer(){

        this.name = "Beer";

    }

    @Override
    public void play(Player player, Deck deck, DiscardDeck discardDeck, Collection<Player> allPlayers){
        player.setLives(player.getLives() + 1);
        player.getHand().remove(this);
        System.out.println(GREEN + "You drank beer +1 life!" + RESET);
    }

}
