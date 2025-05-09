package card;

import deck.Deck;
import deck.DiscardDeck;
import player.Player;
import java.util.Collection;

public class Indians extends Brown{

    public Indians(){
        this.name = "Indians";
    }

    @Override
    public void play(Player player, Deck deck, DiscardDeck discardDeck, Collection<Player> allPlayers){

        for(Player p : allPlayers){
            if(!p.checkBang()){
                p.setLives(p.getLives() - 1);
            }

        }
        player.getHand().remove(this);
    }

}