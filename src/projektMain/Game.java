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
                System.out.println("Player"+pointer.name);
                System.out.println("Vad vill du göra?:\n" +
                        "Köpa ett djur(1)\n" +
                        "Sälja ett djur(2)\n" +
                        "Köpa foder(3)\n" +
                        "Para djuren(4)");
                int choice = scanInt.nextInt();
                while (choice<1 || choice>4){//Makes sure number is 1,2,3 or 4
                    System.out.println("Du måste skriva 1,2,3 eller 4");
                    choice=scanInt.nextInt();
                }
                switch(choice){
                    case 1 -> {
                        System.out.println("Vilket djur vill du köpa?");
                        pointer.money-=100;
                        //pointer.playerOwnedAnimals.add(new animal);
                        //Animal doesent exist yet, so it does nothing.
                        System.out.println("Player"+pointer.name+ " har "+pointer.money+"kr");
                    }
                    case 2 -> {
                        System.out.println("Vad vill du sälja?");
                        var animal = scanLine.nextLine();
                        pointer.money += 100;//temporary, will give player sold animal value
                        pointer.playerOwnedAnimals.remove(animal);
                        System.out.println("Player"+pointer.name+ " har "+pointer.money+"kr");
                    }
                    case 3 -> {

                    }
                    case 4 -> {

                    }

                }

            }

            numberOfRounds--;
        }



    }

}
