package AboutJAVA.Payment;

public class Account {

    private String name;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void payAmount(double amount) {
        this.balance -= amount;
    }

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }


}
