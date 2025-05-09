package card;

import deck.Deck;
import deck.DiscardDeck;
import player.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collection;

public class Dynamite extends Blue {

    String RED = "\u001B[31m";
    String RESET = "\u001B[0m";

    public Dynamite() {

        this.name = "Dynamite";
    }


    @Override
    public void play(Player player, Deck deck, DiscardDeck discardDeck, Collection<Player> allPlayers) {

        player.putCardIntoBlue(this);
        player.getHand().remove(this);
        System.out.println(RED + "Player " + player.getName() + " put DYNAMITE in front of him" + RESET);

    }


    public boolean checkExplosion(Player player) {

        if(rnd.nextInt(8) == 0){
            player.setLives(player.getLives() - 3);
            player.getBlueCards().remove(this);
            System.out.println(RED + "DYNAMITE EXPLODED ON PLAYER " + player.getName() + RESET);
            return true;
        }
        System.out.println(GREEN + "The Dynamite didn't explode on player " + player.getName() + RESET);
        return false;

    }

    public void passToPrevious(Player player, Collection<Player> allPlayers){
        ArrayList<Player> playerList = new ArrayList<>(allPlayers);

        int index = playerList.indexOf(player);

        if(index - 1 < 0){
            System.out.println(YELLOW + "The dynamite is passed to player " + playerList.get(playerList.size() - 1).getName() + RESET);
            player.getBlueCards().remove(this);
            playerList.get(playerList.size() - 1).putCardIntoBlue(this);

        }
        else{
            System.out.println(YELLOW + "The dynamite is passed to player " + playerList.get(index - 1).getName() + RESET);
            player.getBlueCards().remove(this);
            playerList.get(index - 1).putCardIntoBlue(this);
        }

    }


}

