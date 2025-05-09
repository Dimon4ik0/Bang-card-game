package card;

import deck.DiscardDeck;
import player.Player;
import deck.Deck;


import java.util.Collection;
import java.util.Random;

public abstract class Blue  extends Card{

    Random rnd = new Random();

    @Override
    public abstract void play(Player player, Deck deck, DiscardDeck discardDeck, Collection<Player> allPlayers);


}
