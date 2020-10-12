package projektMain;

import java.util.ArrayList;
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
        System.out.println("Vilket kön? male famale");
        String gender = scanLine.nextLine().toUpperCase();
        //int animalType= scanInt.nextInt();
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

}

