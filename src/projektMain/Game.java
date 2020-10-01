package projektMain;

public class Game {

    public Game(int numberOfPlayers, int numberOfRounds){
        int playerNum = 1;
        while(numberOfPlayers > 0){
            new Player("Player"+playerNum, 1000, null);
            playerNum++;
            numberOfPlayers--;

        }
        //Playing the rounds
        while(numberOfRounds > 0){





            numberOfRounds--;
        }



    }

}
