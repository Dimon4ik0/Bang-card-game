package gameLogic;

import deck.DiscardDeck;
import player.Player;
import utility.KeyboardInput;
import deck.Deck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        String GREEN = "\u001B[32m";

        String RESET = "\u001B[0m";

        KeyboardInput keyboard = new KeyboardInput();

        Deck deck = new Deck(keyboard);

        DiscardDeck discardDeck = new DiscardDeck();

        ArrayList<Player> allPlayers = new ArrayList<>();

        GameManager gameManager = new GameManager();


        System.out.println("How many players will be participating?");
        int number_of_players = keyboard.readInt();

        if(number_of_players < 2){
            System.out.println("The number of players can't be lower than 2");
            number_of_players = keyboard.readInt();
        }

        for(int i = 1; i <= number_of_players; i++) {

            System.out.println("player " + i + " is called: ");
            Player player = new Player();
            if (player.getName().isEmpty()) {
                System.out.println("Name can't be empty");
                System.out.println("Please enter Player's name again");
                allPlayers.remove(player);
                i--;
                continue;
            }
            allPlayers.add(player);

        }

        for(int i = 0; i < number_of_players; i++) {
            while(allPlayers.get(i).getHand().size() != 4){
                allPlayers.get(i).takeCardFromDeck(deck);

            }
        }

        while(allPlayers.size() > 1){

            for(int i = 0; i < allPlayers.size(); i++) {
                for(int t = 0; t < 2; t++){
                    if(deck.getCards().isEmpty()){
                        System.out.println("Deck is empty");
                        break;
                    }
                    else{
                        allPlayers.get(i).takeCardFromDeck(deck);

                    }

                }

                if(allPlayers.get(i).getLives() <= 0){
                    System.out.println("---------------------------");
                    System.out.println("Player " + allPlayers.get(i).getName() + " is out");
                    System.out.println("---------------------------");
                    allPlayers.remove(allPlayers.get(i));
                    break;

                }

                System.out.println("---------------------------");
                System.out.println(allPlayers.get(i).getName() + "'s " + "turn");
                System.out.println("Current amount of lives: " + allPlayers.get(i).getLives());
                allPlayers.get(i).playerTurn(deck,allPlayers, discardDeck, gameManager);
                System.out.println(allPlayers.get(i).getLives());

                if(allPlayers.get(i).getLives() <= 0){
                    System.out.println("---------------------------");
                    System.out.println("Player " + allPlayers.get(i).getName() + " is out");
                    System.out.println("---------------------------");
                    allPlayers.remove(allPlayers.get(i));
                    break;

                }

                if(allPlayers.get(i).getHand().size() > allPlayers.get(i).getLives()){
                    while(allPlayers.get(i).getHand().size() != allPlayers.get(i).getLives()){
                        allPlayers.get(i).putCardIntoDiscardDeck(discardDeck);

                    }
                }
            }


        }
        System.out.println(GREEN + "The winner of the match is player " + allPlayers.iterator().next().getName() + RESET);


    }

}


