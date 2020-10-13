package projektMain;

public abstract class Animal {

    public double price;
    protected String name;
    protected String gender;
    protected double health = 1;//Don't need that in the constructor
    //You only need it in the constructor when it can change between new instances
    // Animals always start on 100 health and therefore does health not need to be the in constructor

    public Animal(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    public double getPrice(){
        return this.price;
    }

}
