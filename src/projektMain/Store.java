package projektMain;

import java.util.Scanner;
enum gender{
    MALE,
    FEMALE
}

public class Store {
    public Animal createNewAnimal(int animalType) {
        Scanner scanInt = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);
        String[] animalTypeName = {"katten", "hunden", "fågeln",  "fisken", "hästen"};
        System.out.println("Vad vill du döpa " + animalTypeName[animalType - 1] + "?");
        String name = scanInt.nextLine();
        System.out.println("Vilket kön? male or female");
        String gender = scanLine.nextLine().toUpperCase();
        while (!gender.equals("MALE")&&!gender.equals("FEMALE")){
            System.out.println("Vilket kön? male or female");
            gender = scanLine.nextLine().toUpperCase();
        }
        Animal newAnimal = null;
        switch(animalType) {
            case 1 -> newAnimal = new Cat(name, gender);
            case 2 -> newAnimal = new Dog(name, gender);
            case 3 -> newAnimal = new Bird(name, gender);
            case 4 -> newAnimal = new Fish(name, gender);
            case 5 -> newAnimal = new Horse(name, gender);
        }

        return newAnimal;
    }
    public Food createNewFood(int foodType){
        Scanner scanDouble = new Scanner(System.in);
        System.out.println("Hur många kg mat vill du köpa?");
        double kg = scanDouble.nextDouble();
        Food newFood = null;
        switch(foodType){
            case 1 -> newFood = new CarnivoreFood(kg);
            case 2 -> newFood = new HerbivoreFood(kg);
            case 3 -> newFood = new OmnivoreFood(kg);
        }

        return newFood;
    }

    public void sellEverything(Player player) {
        for(Animal animal : player.playerOwnedAnimals){
            player.money+=(animal.price*animal.health);
        }
        System.out.println(player.name + " has got " + (Math.round(player.money*100)/100.0));
    }

    public void sellAnimal(Player player, String animal) {
        for(int i = player.playerOwnedAnimals.size()-1; i>=0; i--){
            if(player.playerOwnedAnimals.get(i).name.equals(animal)){
                player.money+=(player.playerOwnedAnimals.get(i).price*player.playerOwnedAnimals.get(i).health);
                player.playerOwnedAnimals.remove(i);
            }
        }

        /*
        for(Animal sellAnimal: player.playerOwnedAnimals){
            if(sellAnimal.name.equals(animal)){
                player.money+=(sellAnimal.price*sellAnimal.health);
                player.playerOwnedAnimals.remove(sellAnimal);
            }
        }
        */
    }
}


