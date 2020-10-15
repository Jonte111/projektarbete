package projektMain;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    public int name;
    public double money;
    public ArrayList<Animal> playerOwnedAnimals = new ArrayList<>();
    public ArrayList<Food> playerOwnedFood = new ArrayList<>();
    Scanner scanLine = new Scanner(System.in);
    Random rand = new Random();
    Store store = new Store();

    //The two arrays dont need to be in the constructor because they always are the same.
    //You only need it in the constructor when it can change between new instances
    //Player always start with two empty arraylists.

    public Player(int name, double money) {
        this.name = name;
        this.money = money;
    }

    public void getOwnedAnimals() {
        if(playerOwnedAnimals.isEmpty()){
            System.out.println("Inget");

        }else{
            for(var animalPointer: playerOwnedAnimals) {
                System.out.println(animalPointer.name +" "
                        + animalPointer.getClass().getSimpleName()+ " "
                        + animalPointer.gender +" "+ animalPointer.health+ " health points");
            }
        }

    }
    public double sellAnimal(String name){

        for(var sA: playerOwnedAnimals){
           if(sA.name.equals(name)){
               double value = sA.health*100;
               playerOwnedAnimals.remove(sA);
               return value;
           }
        }
        return 0;
    }


    public void getOwnedFood() {
        if(playerOwnedFood.isEmpty()){
            System.out.println("Ingen mat");
        }else{
            for(var foodPointer: playerOwnedFood){
                System.out.println(foodPointer.name + " " + foodPointer.kg + " kg");
            }
        }
    }

    public void feedAnimal(String animal) {
        for(var feedPointer : playerOwnedAnimals){
            if(feedPointer.name.equals(animal)){
                System.out.println("Vilken typ av foder vill du mata med?\n"+
                        "Köttätare(c) för katt, hund, fågel och fisk(c)\n"+
                        "Växtätare(h) för häst(h)\n"+
                        "Allätare(o) för hund, fågel och fisk(o)");
                String food = scanLine.nextLine().toUpperCase();
                for(var foodPointer : playerOwnedFood){
                    System.out.println("HEJ" + foodPointer.name);
                    if(foodPointer.name.equals(food)){
                        if(feedPointer.getClass().getSimpleName().equals("Cat")){
                            if(foodPointer.name.equals("C")){
                                feedPointer.health= feedPointer.health+0.1; //Increases health with 0.1 (10%)
                                foodPointer.kg= foodPointer.kg-1;
                                return;
                            }else{
                                System.out.println("Djurplågeri!!!");
                            }
                        }else if(feedPointer.getClass().getSimpleName().equals("Dog")){
                            if(foodPointer.name.equals("C")|| foodPointer.name.equals("O")){
                                feedPointer.health= feedPointer.health+0.1; //Increases health with 0.1 (10%)
                                foodPointer.kg= foodPointer.kg-1;
                                return;
                            }else{
                                System.out.println("Djurplågeri!!!");
                            }
                        }else if(feedPointer.getClass().getSimpleName().equals("Bird")){
                            if(foodPointer.name.equals("C")|| foodPointer.name.equals("O")){
                                feedPointer.health= feedPointer.health+0.1; //Increases health with 0.1 (10%)
                                foodPointer.kg= foodPointer.kg-1;
                                return;
                            }else{
                                System.out.println("Djurplågeri!!!");
                            }
                        }else if(feedPointer.getClass().getSimpleName().equals("Fish")) {
                            if (foodPointer.name.equals("C") || foodPointer.name.equals("O")) {
                                feedPointer.health = feedPointer.health + 0.1; //Increases health with 0.1 (10%)
                                foodPointer.kg = foodPointer.kg - 1;
                                return;
                            } else {
                                System.out.println("Djurplågeri!!!");
                            }
                        }else if(feedPointer.getClass().getSimpleName().equals("Häst")) {
                            if (foodPointer.name.equals("H")) {
                                feedPointer.health = feedPointer.health + 0.1; //Increases health with 0.1 (10%)
                                foodPointer.kg = foodPointer.kg - 1;
                                return;
                            } else {
                                System.out.println("Djurplågeri!!!");
                            }
                        }
                    }
                }
            }
        }
    }

    public void removeCheats() {
        playerOwnedFood.removeIf(cheater -> cheater.kg <= 0);
    }
    /*
    public void removeCheats() {
        for(var cheater: playerOwnedFood){
            if(cheater.kg<= 0){
                playerOwnedFood.remove(cheater);
            }
        }
    }

     */
    public void playerAnimalsAge() {
        for(var getOlder: playerOwnedAnimals){
            // Create a random number between 0.10 - 0.30, with max two decimals
            var randomHealth = Math.round(Math.random() * 20 + 10) / 100.0;
            getOlder.health-=randomHealth;
        }
    }

    public void mateAnimal() {
        System.out.println("Vilka djur vill du para? Måste vara olika djurtyper och olika kön\n" +
                "Första djuret:");
        String firstAnimal = scanLine.nextLine();
        System.out.println("Andra djuret:");
        String secondAnimal = scanLine.nextLine();
        for(var animalOne: playerOwnedAnimals){
            if(animalOne.name.equals(firstAnimal)){
                for(var animalTwo : playerOwnedAnimals){
                    if(animalTwo.name.equals(secondAnimal)){
                        if(animalOne.getClass().equals(animalTwo.getClass())&&
                                !animalOne.gender.equals(animalTwo.gender)){
                            int offSpring = rand.nextInt(2);
                            if(offSpring==1){
                                var animalType = animalOne.getClass().getSimpleName();
                                if(animalType.equals("Cat")){
                                    playerOwnedAnimals.add(store.createNewAnimal(1));
                                }else if(animalType.equals("Dog")){
                                    playerOwnedAnimals.add(store.createNewAnimal(2));
                                }else if(animalType.equals("Bird")){
                                    playerOwnedAnimals.add(store.createNewAnimal(3));
                                }else if(animalType.equals("Fish")){
                                    playerOwnedAnimals.add(store.createNewAnimal(4));
                                }else if(animalType.equals("Horse")){
                                    playerOwnedAnimals.add(store.createNewAnimal(5));
                                }

                            }else{
                                System.out.println("Inga djur från parningen");
                            }

                        }


                    }
                }
            }
        }
    }
}
