package model;

//CreditCard class which includes details about a credit card
public class CreditCard {
    private String name;
    private int balance;
    private int limit;

    public CreditCard(String name, int balance, int limit) {
        this.name = name;
        this.balance = balance;
        this.limit = limit;
    }

    // REQUIRES: cost is greater than 0,
    //           balance + cost does not exceed limit
    // MODIFIES: this
    // EFFECTS: Adds cost to balance,
    //          returns true if new balance does not exceed limit
    public boolean spend(int cost) {
        if (balance + cost <= limit) {
            balance += cost;
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: amount is greater than 0,
    //           balance - amount is no less than 0
    // MODIFIES: this
    // EFFECTS: Pays off current balance with given amount
    //          returns true if new balance is non-zero
    public boolean payBill(int amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
