package player;

import card.*;
import deck.DiscardDeck;
import gameLogic.GameManager;
import utility.KeyboardInput;
import deck.Deck;

import java.util.ArrayList;
import java.util.Collection;

public class Player {


    String RESET = "\u001B[0m";

    String RED = "\u001B[31m";





    private ArrayList<Card> blueCards = new ArrayList<>();

    KeyboardInput keyboard = new KeyboardInput();

    protected Card card;

    private ArrayList<Card> hand = new ArrayList<>();

    private int lives;

    private String name;

    private String color;

    private String reset = "\u001B[0m";

    public Player(){

        this.lives = 4;
        this.name = keyboard.readString();

    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void printOutHand(){
        for(int i = 0; i < hand.size(); i++){
            System.out.println(i + 1 + "." + hand.get(i).getName());

        }
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void playCard(Card card, Deck deck, Collection<Player> allPlayers,DiscardDeck discardDeck){

        card.play(this,deck,discardDeck,allPlayers);
        discardDeck.discardCard(card);


    }

    public void takeCardFromDeck(Deck deck){

        if(deck.getCards().isEmpty()){
            System.out.println("Deck is empty");

        }
        else {
            hand.add(deck.drawCard());
        }



    }

    public void putCardIntoDiscardDeck(DiscardDeck discardDeck){
        System.out.println("The amount of cards you have exceeds the limit");
        System.out.println("Choose cards to discard: ");
        printOutHand();
        int input = keyboard.readInt();

        if(input > 0 && input <= hand.size()){
            discardDeck.discardCard(hand.get(input - 1));
            hand.remove(input - 1);
        }

    }
    public boolean checkMissed() {

        for (Card card1 : hand) {
            if (card1 instanceof Missed) {
                hand.remove(card1);
                return true;
            }
        }
        return false;
    }

    public boolean checkBang(){
        for(Card c : hand){
            if(c instanceof Bang){
                hand.remove(c);
                return true;
            }
        }
        return false;
    }



    public void putCardIntoBlue(Card card){
        blueCards.add(card);
    }

    public ArrayList<Card> getBlueCards() {
        return blueCards;
    }

    public void setBlueCard(Card card) {
        blueCards.add(card);
    }

    public void playerTurn(Deck deck, Collection<Player> allPlayers, DiscardDeck discardDeck, GameManager gameManager){


        boolean stay = true;

        for(Card b : blueCards){
            if(b instanceof Dynamite){
                if(!((Dynamite) b).checkExplosion(this)){
                    ((Dynamite) b).passToPrevious(this,allPlayers);
                }


                break;
            }

            if(b instanceof Prison){
                if(!((Prison) b).checkPrison(this)) {
                    System.out.println("Prison card still on player " + name + " skipping turn");
                    stay = false;


                }
                else{
                    System.out.println("Prison card removed");
                    break;

                }

            }
        }

        while(stay) {

            if (hand.isEmpty()) {
                System.out.println("No cards ending player's turn");
                stay = false;
                break;
            }

            System.out.print("Blue cards on " + this.getName() + ": ");
            for(int i = 0; i < this.getBlueCards().size(); i++){
                System.out.print(" " + blueCards.get(i).getName() + " ");
            }

            System.out.println();

            for (int i = 0; i < hand.size(); i++) {
                System.out.println(i + 1 + "." + hand.get(i).getName());
            }

            int input = keyboard.readInt();
            if(input > 0 && input <= hand.size()){
                playCard(hand.get(input - 1), deck, allPlayers, discardDeck);
                gameManager.checkDeadPlayers(allPlayers);
            }

            else if (hand.isEmpty()) {
                System.out.println("No cards ending player's turn");
                stay = false;
                break;
            }

            else if(input == 0){
                stay = false;

            }
            else{
                System.out.println("Bad input. Try again");
            }

        }
    }

    public String getColoredName(){
        return color + name + reset;
    }



}

