import java.util.Scanner;

public class Mainclass {
    public static void main(String[] args) throws Exception {

        //new object from class
        Character character = new Character();

        //variables for taking user input
        Scanner scan = new Scanner(System.in);
        int choise = -1;

        //navigation menu for user
        while(choise != 0){
            System.out.println("*** BATTLE SIMULATOR ***");
            System.out.println("1) Create a character");
            System.out.println("2) Fight with a character");
            System.out.println("0) Quit");
            System.out.print("Your choice: ");
            choise = scan.nextInt();

            //print character and weapon options from methods in Character class
            if(choise == 1){
                character.pickchr();
                character.pickwp();

            //method that prints character information received from user inputs
            } else if(choise == 2){
                character.fight();
            }
        }

    }
}