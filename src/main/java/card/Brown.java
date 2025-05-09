package card;

import deck.Deck;
import deck.DiscardDeck;
import player.Player;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Brown extends Card{


    @Override
    public abstract void play(Player player, Deck deck, DiscardDeck discardDeck, Collection<Player> allPlayers);

}
