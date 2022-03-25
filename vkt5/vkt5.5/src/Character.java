import java.util.Scanner;

public class Character {

    private String chr;
    public String wp;
    private int choise;

    public Character(){
        String chr;
        String wp;
    }

    Scanner scan = new Scanner(System.in);

    public void pickchr(){
        System.out.println("Choose your character: ");
        System.out.println("1) King");
        System.out.println("2) Knight");
        System.out.println("3) Queen");
        System.out.println("4) Troll");
        System.out.print("Your choice: ");
        choise = scan.nextInt();

        if(choise == 1){
            chr = "King";
        }else if (choise == 2){
            chr = "Knight";
        }else if(choise == 3){
            chr = "Queen";
        }else if(choise == 4){
            chr = "Troll";
        }
    }

    public void pickwp(){
        System.out.println("Choose your weapon: ");
        System.out.println("1) Knife");
        System.out.println("2) Axe");
        System.out.println("3) Sword");
        System.out.println("4) Club");
        System.out.print("Your choice: ");
        choise = scan.nextInt();

        if (choise == 1){
            wp = "Knife";
        }
        else if (choise == 2){
            wp = "Axe";
        }
        else if (choise == 3){
            wp = "Sword";
        }
        else if (choise == 4){
            wp = "Club";
        }

    }

    public void fight(){
        System.out.println(chr + " fights with weapon " + wp);
    }
}