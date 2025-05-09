package card;

import deck.DiscardDeck;
import player.Player;
import deck.Deck;
import java.util.Collection;

public class Barrel extends Blue{

    public Barrel(){
        this.name = "Barrel";
    }

    @Override
    public void play(Player player, Deck deck, DiscardDeck discardDeck, Collection<Player> allPlayers){


        for(Card c : player.getBlueCards()){
            if(c instanceof Barrel){
                System.out.println("Player " + player.getName() + " already has a Barrel on him");
                return;
            }
        }

        System.out.println("Player " + player.getName() + " put Barrel in front of him");
        player.putCardIntoBlue(this);
        player.getHand().remove(this);


    }

    public boolean playBarrel(Player player){
        if(rnd.nextInt(4) == 0){
            System.out.println("Player " + player.getName() + " " + " used Barrel, dodged the Bang");
            player.getBlueCards().remove(this);
            return true;

        }
        return false;
    }




}