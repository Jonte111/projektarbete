package projektMain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //commandLineApp
        System.out.println("How many players do you want?");
        int numberOfPlayers = scan.nextInt();
        System.out.println("How many rounds?");
        int numberOfRounds= scan.nextInt();

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

    }
}
