package projektMain;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<Player>();
    public Game(int numberOfPlayers, int numberOfRounds){
        int playerNum = 1;
        while(numberOfPlayers > 0){
            players.add( new Player("Player"+playerNum, 1000, null));
            numberOfPlayers--;
            playerNum++;
        }
        //Playing the rounds
        while(numberOfRounds > 0){
            System.out.println(players.name);





            numberOfRounds--;
        }



    }

}
