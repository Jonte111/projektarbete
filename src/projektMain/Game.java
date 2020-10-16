package projektMain;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Player> players = new ArrayList<Player>();
    Store store = new Store();//initialize store

    public Game(int numberOfPlayers, int numberOfRounds){
        Scanner scanInt = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);
        String playerName;
        int playerNum = 1;
        int animalType;
        int caseOneChoise=1;
        int caseTwoChoice=1;
        int caseThreeChoice=1;
        int caseFiveChoice;

        while(numberOfPlayers > 0){
            System.out.println("Vad vill du döpa spelar " +playerNum +" till?");
            playerName=scanLine.nextLine();
            players.add( new Player(playerName, 1000));
            numberOfPlayers--;
            playerNum++;
        }

        //Playing the rounds
        while(numberOfRounds > 0){
            for(var pointer: players){
                System.out.println("--------------------------------------");
                pointer.printOutEverything();

                System.out.println("Vad vill du göra?:\n" +
                        "Köpa ett djur(1)\n" +
                        "Sälja ett djur(2)\n" +
                        "Köpa foder(3)\n" +
                        "Para djuren(4)\n" +
                        "Föda djuren(5)");
                int choice = scanInt.nextInt();
                while (choice<1 || choice>5){//Makes sure number is 1,2,3 or 4
                    System.out.println("Du måste skriva 1,2,3 eller 4");
                    choice=scanInt.nextInt();
                }
                switch(choice){
                    case 1 -> {
                        caseOneChoise=1;
                        while(caseOneChoise==1){

                            System.out.println("Vilket djur vill du köpa?\n"+
                                    "Katt(1)\n"+
                                    "Hund(2)\n"+
                                    "Fågel(3)\n"+
                                    "Fisk(4)\n"+
                                    "Häst(5)");
                            animalType = scanInt.nextInt();
                            var newAnimal = store.createNewAnimal(animalType);
                                if(pointer.money> newAnimal.getPrice()){
                                    pointer.playerOwnedAnimals.add(newAnimal);
                                    pointer.money -= newAnimal.getPrice();

                                }else{
                                    System.out.println("No money!");
                                }

                            pointer.printOutEverything();

                            System.out.println("Vill du fortsätta köpa djur? tryck 1 annars 0");
                            caseOneChoise=scanInt.nextInt();
                        }

                    }
                    case 2 -> {
                        caseTwoChoice=1;
                        while(caseTwoChoice==1){
                            if(!pointer.playerOwnedAnimals.isEmpty()){
                                System.out.println("Vad vill du sälja?");
                                var animal = scanLine.nextLine();
                                pointer.money += pointer.sellAnimal(animal);
                                pointer.printOutEverything();

                                System.out.println("Vill du sälja fler djur (1) annars (0)");
                                caseTwoChoice=scanInt.nextInt();
                            }else{
                                System.out.println("Du har inget att sälja");
                            }

                        }
                    }
                    case 3 -> {
                        caseThreeChoice=1;
                        while(caseThreeChoice ==1){
                            System.out.println("Vilken typ av foder vill du köpa?\n"+
                                    "Köttätare(1) för katt, hund, fågel och fisk\n"+
                                    "Växtätare(2) för häst\n"+
                                    "Allätare(3) för hund, fågel och fisk");
                            var foodType = scanInt.nextInt();
                            var newFood = store.createNewFood(foodType); //sends type of food wanted
                                if(pointer.money>= newFood.getPrice()){
                                    pointer.playerOwnedFood.add(newFood);
                                    pointer.money -= newFood.getPrice();
                                }else{
                                    System.out.println("NEED MORE MINERALS");
                                }

                            pointer.printOutEverything();

                            System.out.println("Vill du köpa mer mat?(1) eller (0) för att sluta");
                            caseThreeChoice= scanInt.nextInt();
                            pointer.removeCheats();

                        }

                    }
                    case 4 -> {
                        boolean mated = false;
                        int numberAnimals=0;
                        for(var animal: pointer.playerOwnedAnimals){
                            numberAnimals++;
                        }
                        while(!mated&&numberAnimals>=2){
                            int animal = pointer.mateAnimal();
                            if(animal >0 && animal <= 5) {
                                pointer.playerOwnedAnimals.add(store.createNewAnimal(animal));
                                mated = true;
                            }
                            else if(animal==0){
                                mated=true;
                            }else if(animal==6){
                                System.out.println("Du försökte para något som inte går, försök igen");
                            }else{
                                System.out.println("Something went wrong, try again");
                            }
                        }
                    }
                    case 5 -> {
                        caseFiveChoice=1;
                        pointer.removeCheats();

                        if(!pointer.playerOwnedFood.isEmpty()){
                            pointer.removeCheats();
                            while(caseFiveChoice==1&&!pointer.playerOwnedFood.isEmpty()){
                                pointer.removeCheats();
                                pointer.getOwnedAnimals();
                                System.out.println("Vem vill du ge mat till?");
                                var animal = scanLine.nextLine();
                                pointer.feedAnimal(animal);

                                pointer.printOutEverything();

                                System.out.println("Vill du fortsätta ge djur mat?(1) annars (0)");
                                caseFiveChoice=scanInt.nextInt();
                                pointer.removeCheats();
                            }
                        }else{
                            System.out.println("Du har inget att mata med.");
                        }

                    }

                }
                pointer.playerAnimalsAgeAndDie();
            }

            numberOfRounds--;
        }
        for(Player player : players){
            store.sellEverything(player);
        }



    }

}
