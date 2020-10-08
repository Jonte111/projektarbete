package projektMain;

public class Cat extends Animal{
    double catPrice = 100;
    public Cat(String name, String gender){
        super(name, gender);
    }
/*
    public static double catPrice() {
        return catPrice();
    }*/

    double getCatPrice(){
        return catPrice;
    }


}
