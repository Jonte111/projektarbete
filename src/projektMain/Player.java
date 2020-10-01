package projektMain;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private ArrayList<Animal> playerOwnedAnimals;
    //Player needs a ArrayList to store animals and food
    //Hashtable<food, quantity>;
    public Player(String name, int money, ArrayList<Animal> playerOwnedAnimals) {
        this.name = name;
        this.money = money;
    }


}
