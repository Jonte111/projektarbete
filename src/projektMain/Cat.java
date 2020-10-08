package projektMain;

public class Cat extends Animal{

    public Cat(String name, String gender){
        super(name, gender);
        price = 100;//Must be here and not outside of constructor
    }

}
