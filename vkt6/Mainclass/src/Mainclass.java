import java.util.Scanner;

public class Mainclass {    
    public static void main(String[] args) throws Exception {

        int choise = -1; //apumuuttuja valikkorakenteeseen

        Menu m = new Menu();
        Bank bank = new Bank();
        
        while(choise != 0){
            m.menu();
            Scanner sc = new Scanner(System.in);
            System.out.print("Your choice: ");
            choise = sc.nextInt();

            if(choise == 1){
                Scanner scan = new Scanner(System.in);
                System.out.print("Give an account number: ");
                String numb = scan.nextLine();
                System.out.print("Amount of money to deposit: ");
                int balance = scan.nextInt();
                bank.addRegularAccount(numb, balance); //add regular account
                System.out.println("Account created.");
                
            } else if (choise == 2){
                Scanner scan = new Scanner(System.in);
                System.out.print("Give an account number: ");
                String numb = scan.nextLine();
                System.out.print("Amount of money to deposit: ");
                int balance = scan.nextInt();
                System.out.print("Give a credit limit: ");
                int credit = scan.nextInt();
                bank.addCreditAccount(numb, balance, credit); //add credit account
                System.out.println("Account created.");

            } else if (choise == 3){
                Scanner scan = new Scanner(System.in);
                System.out.print("Give an account number: ");
                String numb = scan.nextLine();
                System.out.print("Amount of money to deposit: ");
                int deposit = scan.nextInt();
                bank.depositMoney(numb, deposit);
                
            } else if (choise == 4){
                Scanner scan = new Scanner(System.in);
                System.out.print("Give an account number: ");
                String numb = scan.nextLine();
                System.out.print("Amount of money to withdraw: ");
                int withdraw = scan.nextInt();
                bank.withdrawMoney(numb, withdraw);

            } else if (choise == 5){
                Scanner scan = new Scanner(System.in);
                System.out.print("Give the account number of the account to delete: ");
                String numb = scan.nextLine();
                bank.removeAccount(numb);
                System.out.println("Account removed.");

            } else if (choise == 6){
                Scanner scan = new Scanner(System.in);
                System.out.print("Give the account number of the account to print information from: ");
                String numb = scan.nextLine();
                bank.findAccountInfo(numb);
                System.out.println("");

            } else if (choise == 7){
                bank.printAccounts();

            } else if(choise == 0){

                break;

            } else{

                System.out.println("Invalid choice.");

            }
        }
        
    }

}

class Menu{
    public void menu(){
            System.out.println("\n*** BANK SYSTEM ***");
            System.out.println("1) Add a regular account");
            System.out.println("2) Add a credit account");
            System.out.println("3) Deposit money");
            System.out.println("4) Withdraw money");
            System.out.println("5) Remove an account");
            System.out.println("6) Print account information");
            System.out.println("7) Print all accounts");
            System.out.println("0) Quit");
    }
}
