import java.util.ArrayList;

public class BottleDispenser {
    private int bottles;
    private int money;
    Bottle pullo = new Bottle(); 
    ArrayList<Bottle> entries = new ArrayList<>();

    public BottleDispenser() {
        bottles = 5;
        money = 0;


        for(int i = 0; i < bottles; i++) {
            Bottle pullo = new Bottle();
            entries.add(pullo);
        }
    }
    
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    
    public void buyBottle() {
        if (bottles == 0){
            System.out.println("Running out of bottles");
        } if (money < pullo.getPrice()){ 
            System.out.println("Add money first!");
        } else {
            money -= 1;
            bottles -= 1;
            System.out.println("KACHUNK! " +pullo.getName()+ " came out of the dispenser!");}{ 

        }}
    public void giveList() {
        for(int i = 0; i < bottles; i++) {
            Bottle pullo = entries.get(i);
            System.out.println((i+1)+". Name: "+ pullo.getName());
            System.out.println("\t"+"Size: "+pullo.getSize()+"\t"+"Price: "+pullo.getPrice());
        }
    }      
    
    
    public void returnMoney() {
        money = 0;
        System.out.println("Klink klink. Money came out!");
    }



}