package projektMain;

public class Game {

    public Game(int numberOfPlayers, int numberOfRounds){
        int num = 1;
        while(numberOfPlayers > 0){
            new Player("Player"+num, 1000);
            num++;
            numberOfPlayers--;

        }

        while(numberOfRounds > 0){





            numberOfRounds--;
        }



    }

}
