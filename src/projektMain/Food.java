package projektMain;

public abstract class Food {
    protected double price;
    protected String name;
    protected double kg;
    public Food(double kg){
        this.kg = kg;
    }
    public double getPrice(){
        return this.price;
    }
    //public String getName(){ return this.name;}
}
