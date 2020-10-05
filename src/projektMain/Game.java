package projektMain;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Player> players = new ArrayList<Player>();
    public Game(int numberOfPlayers, int numberOfRounds){
        Scanner scan = new Scanner(System.in);
        int playerNum = 1;
        while(numberOfPlayers > 0){
            players.add( new Player(playerNum, 1000, null));
            numberOfPlayers--;
            playerNum++;
        }
        //Playing the rounds
        while(numberOfRounds > 0){
            for(var pointer: players){
                System.out.println("Name of the player");
                System.out.println(pointer.name);
                System.out.println("Vad vill du göra?:\n" +
                        "Köpa ett djur(1)\n" +
                        "Köpa foder(2)\n" +
                        "Para djuren(3)");
                int choice = scan.nextInt();
                if(choice==1){

                }else if(choice==2){

                }else if(choice==3){

                }else{
                    System.out.println("Du skrev något som inte fanns");
                    continue;
                }

            }

            numberOfRounds--;
        }



    }

}
