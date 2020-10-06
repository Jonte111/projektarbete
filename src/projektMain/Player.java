package projektMain;

import java.util.ArrayList;

public class Player {
    public int name;
    public double money;
    ArrayList<Animal> playerOwnedAnimals = new ArrayList<Animal>();

    //ArrayList<Animal> playerOwnedAnimals;
    //Hashtable<String, Integer> food = new Hashtable<String, Integer>();
    //, Hashtable<String, Integer>
    //Player needs a ArrayList to store animals and food
    //Hashtable<food, quantity>; HashMap<String food, int quantity>

    public Player(int name, double money, ArrayList<Animal> playerOwnedAnimals) {
        this.name = name;
        this.money = money;
        this.playerOwnedAnimals=playerOwnedAnimals;

    }


}
