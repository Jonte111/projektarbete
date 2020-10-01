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
                Player p1 = new Player("Player1", 1000);
                new Game();
            }
            case 2 ->{
                System.out.println("Två spelare");
                Player p1 = new Player("Player1", 1000);
                Player p2 = new Player("Player2", 1000);
                new Game();
            }
            case 3 ->{
                System.out.println("Tre spelare");
                Player p1 = new Player("Player1", 1000);
                Player p2 = new Player("Player2", 1000);
                Player p3 = new Player("Player3", 1000);
                new Game();
            }
            case 4 -> {
                System.out.println("Fyra spelare");
                Player p1 = new Player("Player1", 1000);
                Player p2 = new Player("Player2", 1000);
                Player p3 = new Player("Player3", 1000);
                Player p4 = new Player("Player4", 1000);
                new Game();
            }

        }


    }
}
