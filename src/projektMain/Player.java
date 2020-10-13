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
                System.out.println("What do you want to feed it?");
                String food = scanLine.nextLine();
                for(var foodPointer : playerOwnedFood){
                    if(foodPointer.name.equals(food)){
                       feedPointer.health= feedPointer.health+0.1; //Increases health with 0.1 (10%)
                        foodPointer.kg= foodPointer.kg-1;
                        return;
                    }
                }
            }
        }
    }
}
