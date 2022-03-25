import java.util.ArrayList;

public class Bank {

    ArrayList<Account> AccountList = new ArrayList<Account>();

    public Bank(){
        
    }

    public void addRegularAccount(String number, int balance){

        RegularAccount account = new RegularAccount(number, balance);
        AccountList.add(account);
    }

    public void addCreditAccount(String number, int balance, int credit){

        CreditAccount account = new CreditAccount(number, balance, credit);
        AccountList.add(account);
    }


    public void depositMoney(String number, int cash){
        for(Account a : AccountList){
            if(a.number.equals(number)){
                a.addCash(cash);
            }
        }
    }

    public void withdrawMoney(String number, int taken){
        for(Account a : AccountList){
            if(a.number.equals(number)){
                a.withdrawCash(taken);
            }
        }
    }

    public void removeAccount(String number){
        Object removable = "";
        for(Account a : AccountList){
            if(a.number.equals(number)){
                removable = a;
            }
        }
        if(removable != ""){
            AccountList.remove(removable);
        } else{
            System.out.println("Account number couldn't been found");
        }
        
    }

    public void findAccountInfo(String number){
        for(Account a : AccountList){
            if(a.number.equals(number)){
                System.out.print("Account number: " + a.getNumber() + " Amount of money: " + a.getBalance());
                if(a instanceof CreditAccount){
                    System.out.println("Credit limit: " + ((CreditAccount)a).getCredit());
            }
            }
        }
    }

    public void printAccounts(){
        System.out.println("All accounts:");

        for(Account a : AccountList){
            System.out.print("Account number: " + a.getNumber() + " Amount of money: " + a.getBalance());
            if(a instanceof CreditAccount){
                System.out.print(" Credit limit: " + ((CreditAccount)a).getCredit());
            }
            System.out.println("");
        }
    }

}