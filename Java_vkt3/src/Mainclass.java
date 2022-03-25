import java.util.Scanner;

public class Mainclass {
    public static int choice;
    public static void main(String[]args){

      
        BottleDispenser x = new BottleDispenser();
        Scanner object = new Scanner(System.in);
       

        while(true){
            System.out.println("\n*** BOTTLE DISPENSER ***" +"\n"+ "1) Add money to the machine" +"\n"+ "2) Buy a bottle" +"\n"+ "3) Take money out" +"\n"+ "4) List bottles in the dispenser" +"\n"+ "0) End");
            System.out.print("Your choice: ");
            choice = object.nextInt(); 
            if(choice == 1){
                x.addMoney();

            }
            else if(choice == 2){
                x.buyBottle();

            }
            else if(choice == 3){
                x.returnMoney();
            }
            else if(choice == 4){
                x.giveList();
            }
            else if(choice == 0){
                break;
            }
                

            
        }
        object.close();
    }
}