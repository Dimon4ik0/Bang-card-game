package card;

import deck.Deck;
import deck.DiscardDeck;
import player.Player;

import java.util.Collection;

public class Prison extends Blue{

    public Prison(){

        this.name = "Prison";
    }

    @Override
    public void play(Player player, Deck deck, DiscardDeck discardDeck, Collection<Player> allPlayers){

        int i = 1;
        System.out.println("Choose what player to put in Prison:");
        for(Player player1 : allPlayers){
            if(player1.equals(player)){
                continue;
            }
            else {
                System.out.print(i + "." + player1.getName() + " ");
                i++;
            }
        }

        System.out.println();

        String userInput = keyboard.readString(2);

        for(Player player1 : allPlayers) {
            if (player1.getName().equals(userInput)) {
                for (Card c : player1.getBlueCards()) {
                    if (c instanceof Prison) {
                        System.out.println("Player " + player1.getName() + " already in Prison");
                        return;
                    }




                }

                player1.setBlueCard(this);
                player.getHand().remove(this);
                System.out.println("Prison card was used on player " + player1.getName());
            }
        }



    }

    public boolean checkPrison(Player player){

        if(rnd.nextInt(4) == 0){
            player.getBlueCards().remove(this);
            return true;
        }

        return false;

    }



}
