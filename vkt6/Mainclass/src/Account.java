abstract class Account {
    protected String number;
    protected int balance; 

    public Account(String number, int balance){
        this.number = number;
        this.balance = balance;
    }

    public String getNumber(){
        return number;
    }

    public int getBalance(){
        return balance;
    }

    public void addCash(int cash){
        balance = cash + balance;
    }

    public void withdrawCash(int taken){
        balance = balance - taken;
    }

}

class RegularAccount extends Account{

    public RegularAccount(String number, int balance) {
        super(number, balance);
    }
    
}

class CreditAccount extends Account{
    private int credit;
    public CreditAccount(String number, int balance, int credit) {
        super(number, balance);
        this.credit = credit;
    }

    public int getCredit(){
        return credit;
    }
    
}