package card;

import deck.Deck;
import deck.DiscardDeck;
import player.Player;
import utility.KeyboardInput;

import java.util.ArrayList;
import java.util.Collection;

public class Bang extends Brown {

    String RED = "\u001B[31m";
    String YELLOW = "\u001B[33m";
    String RESET = "\u001B[0m";


    public Bang(KeyboardInput keyboard) {
        this.name = "Bang";
        this.keyboard = keyboard;
    }

    @Override
    public void play(Player player, Deck deck, DiscardDeck discardDeck, Collection<Player> allPlayers) {

        int i = 1;
        System.out.println("Choose what player to shoot:");
        for (Player player1 : allPlayers) {
            if (player1.equals(player)) {
                continue;
            } else {
                System.out.print(i + "." + player1.getName() + " ");
                i++;
            }
        }
        System.out.println();

        String userInput = keyboard.readString(2);

        for (Player player1 : allPlayers) {
            if (player1.getName().equals(userInput)) {


                if (!player1.getBlueCards().isEmpty()) {
                    for (Card c : player1.getBlueCards()) { //note to myself, so I guess if a player doesn't have any blue cards this whole cycle is skipped //first here
                        if (c instanceof Barrel) {//second we're here checks if it's barrel
                            if (((Barrel) c).playBarrel(player1)) {
                                player.getHand().remove(this);
                                System.out.println(YELLOW + player1.getName() + " used Barrel card!" + RESET);
                                break;

                            }
                        } else {
                            if (player1.checkMissed()) {
                                player.getHand().remove(this);
                                System.out.println(YELLOW + player1.getName() + " used Missed card!" + RESET);
                            } else {
                                player.getHand().remove(this);
                                player1.setLives(player1.getLives() - 1);
                                System.out.println(RED + "You successfully shot player: " + player1.getName() + RESET);

                                break;

                            }

                        }
                    }//third we're here
                } else if (player1.checkMissed()) {

                    player.getHand().remove(this);
                    System.out.println(YELLOW + player1.getName() + " used Missed card!" + RESET);

                } else {
                    player.getHand().remove(this);
                    player1.setLives(player1.getLives() - 1);
                    System.out.println(RED + "You successfully shot player: " + player1.getName() + RESET);
                  //  player1.checkPlayerStatus(allPlayers);

                }
            }
        }//fourth stop
    }
}