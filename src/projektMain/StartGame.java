package projektMain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StartGame {
    public StartGame(){
        Scanner scan = new Scanner(System.in);
        //commandLineApp

        try{
            System.out.println("Hur många spelare? 1-4 spelare.");
            int numberOfPlayers = scan.nextInt();
            while(numberOfPlayers<1 || numberOfPlayers>4){
                System.out.println("Hur många spelare? 1-4 spelare.");
                numberOfPlayers= scan.nextInt();
            }
            System.out.println("Hur många rundor? 5-30 rundor.");
            int numberOfRounds= scan.nextInt();
            while(numberOfRounds<5 || numberOfRounds>30){
                System.out.println("Hur många rundor? 5-30 rundor.");
                numberOfRounds= scan.nextInt();
            }

            switch(numberOfPlayers){
                case 1 -> {
                    System.out.println("En spelare");
                    new Game(1,numberOfRounds);
                }
                case 2 ->{
                    System.out.println("Två spelare");
                    new Game(2,numberOfRounds);
                }
                case 3 ->{
                    System.out.println("Tre spelare");
                    new Game(3,numberOfRounds);
                }
                case 4 -> {
                    System.out.println("Fyra spelare");
                    new Game(4,numberOfRounds);
                }

            }
        }catch(InputMismatchException e){
            scan.nextLine();// Must have to remove the bad input.
            System.out.println("Du måste skriva en siffra i StartGame när det efterfrågas");
        }

    }



}
