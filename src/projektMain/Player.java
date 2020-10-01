package projektMain;

import java.util.ArrayList;
import java.util.Hashtable;

public class Player {
    private String name;
    private int money;
    private ArrayList<Animal> playerOwnedAnimals;
    //Hashtable<String, Integer> food = new Hashtable<String, Integer>();
    //, Hashtable<String, Integer>
    //Player needs a ArrayList to store animals and food
    //Hashtable<food, quantity>; HashMap<String food, int quantity>

    public Player(String name, int money, ArrayList<Animal> playerOwnedAnimals) {
        this.name = name;
        this.money = money;
        this.playerOwnedAnimals=playerOwnedAnimals;
    }


}
