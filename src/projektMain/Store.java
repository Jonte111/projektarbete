package projektMain;

import java.util.Scanner;
enum gender{
    MALE,
    FEMALE
}

public class Store {

    public Store(int animalType){
        Scanner scanInt = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);

        String name;
        String gender;
        switch(animalType){
           case 1 ->{
               System.out.println("Vad vill du döpa katten till?");
               name=scanInt.nextLine();
               System.out.println("Vilket kön? male famale");
               gender = scanLine.nextLine().toUpperCase();
               new Cat(name,gender);
           }
           case 2 ->{
               new Dog();
           }
           case 3 ->{
               new Bird();
           }
           case 4 ->{
               new Fish();
           }
           case 5 ->{
               new Horse();
           }


        }


    }

}
