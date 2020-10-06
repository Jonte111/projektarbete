package projektMain;

public class Store {

    public Store(int animalType){

        switch(animalType){
           case 1 ->{
               new Cat();
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
