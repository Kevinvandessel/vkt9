import java.util.Scanner;

public class Dog {

    private String dogName = "";
    private String dogSay= ""; 

    public Dog(String name){
        dogName = name.trim();
        dogSay = "Much wow!";  
    }

    

    public String getName(){
        if(dogName.isEmpty() == true){
            dogName = "Doge"; 
        }
        return dogName; 
    }

    public void setSpeak() {

        System.out.print("What does a dog say: ");
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            if(scanner.hasNextBoolean()){
                Boolean bool_token = scanner.nextBoolean();
                System.out.println("Such boolean: " + bool_token);
            } else if(scanner.hasNextInt()){
                Integer int_token = scanner.nextInt();
                System.out.println("Such integer: " + int_token); 
            } else{
                System.out.println(scanner.next());
            }

            }
        }

}