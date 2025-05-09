package card;

import deck.Deck;
import deck.DiscardDeck;
import player.Player;

import java.util.ArrayList;
import java.util.Collection;


public class Stagecoach extends Brown{


    public Stagecoach(){
        this.name = "Stagecoach";
    }


    @Override
    public void play(Player player, Deck deck,DiscardDeck discardDeck, Collection<Player> allPlayers){

        for(int i = 0; i < 2; i++){
            player.takeCardFromDeck(deck);


        }
        player.getHand().remove(this);



    }

}
