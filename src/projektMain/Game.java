package projektMain;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Player> players = new ArrayList<Player>();
    public Game(int numberOfPlayers, int numberOfRounds){
        Scanner scanInt = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);
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
                        "Sälja ett djur(2)\n" +
                        "Köpa foder(3)\n" +
                        "Para djuren(4)");
                int choice = scanInt.nextInt();
                if(choice==1){
                    System.out.println("Vilket djur vill du köpa?");
                    pointer.money-=100;
                    //pointer.playerOwnedAnimals.add(new animal);

                }else if(choice==2){
                    System.out.println("Vad vill du sälja?");
                    var animal = scanLine.nextLine();
                    pointer.money += 100;//temporary, will give player sold animal value
                    pointer.playerOwnedAnimals.remove(animal);
                }else if(choice==3) {

                }else if(choice==4){

                }else{
                    System.out.println("Du skrev något som inte fanns");
                    continue;
                }

            }

            numberOfRounds--;
        }



    }

}
