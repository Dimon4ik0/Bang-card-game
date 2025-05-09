package gameLogic;

import player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GameManager {

    private Collection<Player> allPlayers;

    public GameManager() {
        this.allPlayers = allPlayers;
    }


    public void checkDeadPlayers(Collection<Player> allPlayers){
        Iterator<Player> iterator = allPlayers.iterator();
        while(iterator.hasNext()){
            Player player = iterator.next();
            if(player.getLives() <= 0){
                System.out.println("---------------------------");
                System.out.println("Player " + player.getName() + " is out!");
                System.out.println("---------------------------");
                iterator.remove();
            }
        }
    }

    public Collection<Player> getAllPlayers(){
        return allPlayers;
    }

}
