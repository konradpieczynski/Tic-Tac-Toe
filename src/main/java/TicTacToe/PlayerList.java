package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    List<Player> playerList = new ArrayList<>();

public void addPlayer(Player p){
    playerList.add(p);
}
public Player getPlayer(int x)
{
    return playerList.get(x);
}
public int getPlayerNumber(Player p){
    return  playerList.indexOf(p);
}
    public List<Player> getPlayerList() {
        return playerList;
    }
}
