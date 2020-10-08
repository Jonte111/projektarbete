package projektMain;

import java.util.ArrayList;

public class Player {
    public int name;
    public double money;
    public ArrayList<Animal> playerOwnedAnimals = new ArrayList<>();
    public ArrayList<Food> playerOwnedFood = new ArrayList<Food>();

    //The two arrays dont need to be in the constructor because they always are the same.
    //You only need it in the constructor when it can change between new instances
    //Player always start with two empty arraylists.

    public Player(int name, double money) {
        this.name = name;
        this.money = money;
    }

/*
    public void playerOwnedAnimals(Store store) {
        playerOwnedAnimals.add(store);
    }


 */
    public void addAnimal(Animal animal){
        playerOwnedAnimals.add(animal);
    }
}
