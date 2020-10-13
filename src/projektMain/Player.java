package projektMain;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public int name;
    public double money;
    public ArrayList<Animal> playerOwnedAnimals = new ArrayList<>();
    public ArrayList<Food> playerOwnedFood = new ArrayList<>();
    Scanner scanLine = new Scanner(System.in);

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
                        "Köttätare(1) för katt, hund, fågel och fisk(c)\n"+
                        "Växtätare(2) för häst(h)\n"+
                        "Allätare(3) för hund, fågel och fisk(o)");
                String food = scanLine.nextLine().toUpperCase();
                for(var foodPointer : playerOwnedFood){
                    if(foodPointer.name.equals(food)){
                        if(foodPointer.getClass().getSimpleName().equals("Cat")){
                            if(foodPointer.name.equals("C")){
                                feedPointer.health= feedPointer.health+0.1; //Increases health with 0.1 (10%)
                                foodPointer.kg= foodPointer.kg-1;
                                return;
                            }else{
                                System.out.println("Djurplågeri!!!");
                            }
                        }else if(foodPointer.getClass().getSimpleName().equals("Dog")){
                            if(foodPointer.name.equals("C")|| foodPointer.name.equals("O")){
                                feedPointer.health= feedPointer.health+0.1; //Increases health with 0.1 (10%)
                                foodPointer.kg= foodPointer.kg-1;
                                return;
                            }else{
                                System.out.println("Djurplågeri!!!");
                            }
                        }else if(foodPointer.getClass().getSimpleName().equals("Bird")){
                            if(foodPointer.name.equals("C")|| foodPointer.name.equals("O")){
                                feedPointer.health= feedPointer.health+0.1; //Increases health with 0.1 (10%)
                                foodPointer.kg= foodPointer.kg-1;
                                return;
                            }else{
                                System.out.println("Djurplågeri!!!");
                            }
                        }else if(foodPointer.getClass().getSimpleName().equals("Fish")) {
                            if (foodPointer.name.equals("C") || foodPointer.name.equals("O")) {
                                feedPointer.health = feedPointer.health + 0.1; //Increases health with 0.1 (10%)
                                foodPointer.kg = foodPointer.kg - 1;
                                return;
                            } else {
                                System.out.println("Djurplågeri!!!");
                            }
                        }else if(foodPointer.getClass().getSimpleName().equals("Häst")) {
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
}
