import java.util.Scanner;

public class Mainclass {
    public static void main(String[] args) {
        
        String inputName = "";

        System.out.print("Give a name to the dog: ");
        Scanner scan1 = new Scanner(System.in);
            inputName = scan1.nextLine();
    
        Dog doggo1 = new Dog(inputName); 

        System.out.println("Hey, my name is " + doggo1.getName());

        doggo1.setSpeak(); 
    }
}
