package projektMain;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Player> players = new ArrayList<Player>();
    Store store = new Store();//initialize store

    public Game(int numberOfPlayers, int numberOfRounds){
        Scanner scanInt = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);
        int playerNum = 1;
        int animalType;

        while(numberOfPlayers > 0){

            players.add( new Player(playerNum, 1000));
            numberOfPlayers--;
            playerNum++;
        }
        //Playing the rounds
        while(numberOfRounds > 0){

            int i = 0;
            for(var pointer: players){
                System.out.println("--------------------------------------");
                //--------------------------
                System.out.println("Player"+pointer.name+ " har "+ pointer.money+" kr " + "och äger " +
                        "följande djur");
                players.get(i).getOwnedAnimals();
                System.out.println("och följande foder: ");
                players.get(i).getOwnedFood();
                //-------------------------------------------
                System.out.println("Vad vill du göra?:\n" +
                        "Köpa ett djur(1)\n" +
                        "Sälja ett djur(2)\n" +
                        "Köpa foder(3)\n" +
                        "Para djuren(4)\n" +
                        "Föda djuren(5)");
                int choice = scanInt.nextInt();
                while (choice<1 || choice>4){//Makes sure number is 1,2,3 or 4
                    System.out.println("Du måste skriva 1,2,3 eller 4");
                    choice=scanInt.nextInt();
                }
                switch(choice){
                    case 1 -> {
                        System.out.println("Vilket djur vill du köpa?\n"+
                                "Katt(1)\n"+
                                "Hund(2)\n"+
                                "Fågel(3)\n"+
                                "Fisk(4)\n"+
                                "Häst(5)");
                        animalType = scanInt.nextInt();
                        var newAnimal = store.createNewAnimal(animalType);
                        pointer.playerOwnedAnimals.add(newAnimal);
                        pointer.money -= newAnimal.getPrice();

                        System.out.println("Player"+pointer.name+ " har "+ pointer.money+" kr " + "och äger ");
                        players.get(i).getOwnedAnimals();//Need an index, print out animals

                    }
                    case 2 -> {
                        System.out.println("Vad vill du sälja?");
                        var animal = scanLine.nextLine();
                        pointer.money += pointer.sellAnimal(animal);
                        //-----------------------------------------
                        System.out.println("Player"+pointer.name+ " har "+ pointer.money+" kr " + "och äger " +
                                "följande djur");
                        players.get(i).getOwnedAnimals();
                        System.out.println("och följande foder: ");
                        players.get(i).getOwnedFood();
                        //--------------------------------------
                    }
                    case 3 -> {
                        System.out.println("Vilken typ av foder vill du köpa?\n"+
                                "Köttätare(1) för katt, hund, fågel och fisk\n"+
                                "Växtätare(2) för häst\n"+
                                "Allätare(3) för hund, fågel och fisk");
                        var foodType = scanInt.nextInt();
                        var newFood = store.createNewFood(foodType); //sends type of food wanted
                        pointer.playerOwnedFood.add(newFood);
                        pointer.money -= newFood.getPrice();
                        //-----------------------------------
                        System.out.println("Player"+pointer.name+ " har "+ pointer.money+" kr " + "och äger " +
                                "följande djur");
                        players.get(i).getOwnedAnimals();
                        System.out.println("och följande foder: ");
                        players.get(i).getOwnedFood();
                        //-------------------------------------

                    }
                    case 4 -> {

                    }
                    case 5 -> {

                    }

                }
                //make for loop that prints out animals money food
                //System.out.println("Player"+pointer.name+ " har "+pointer.money+"kr");
                i++; //counts up to get correct index on what player owns
            }
            //i++; //counts up to get correct index on what player owns

            numberOfRounds--;
        }



    }

}
