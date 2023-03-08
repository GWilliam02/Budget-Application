package model;

import java.util.ArrayList;
import java.util.Objects;

//Wallet includes cash, bank balance, and a list of credit cards.
public class Wallet {

    private int cash;
    private ArrayList<CreditCard> cards;
    private int bankBalance;

    public Wallet() {
        cash = 0;
        bankBalance = 0;
        cards = new ArrayList<>();
    }

    // REQUIRES: amount is greater than 0
    //           bankBalance - amount >= 0
    // MODIFIES: this
    // EFFECTS: subtracts bankBalance by amount
    //          increases cash by amount
    //          Produces true if withdraw successful
    public boolean withdrawCash(int amount) {
        if (bankBalance - amount >= 0) {
            bankBalance -= amount;
            cash += amount;
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: amount is greater than 0
    //           cash - amount >= 0
    // MODIFIES: this
    // EFFECTS: increases bankBalance by amount
    //          subtracts cash by amount
    //          Produces true if deposit successful
    public boolean depositCash(int amount) {
        if (cash - amount >= 0) {
            bankBalance += amount;
            cash -= amount;
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: cc is not null
    // MODIFIES: this
    // EFFECTS: adds credit card (cc) to cards
    public void addCreditCard(CreditCard cc) {
        cards.add(cc);
    }

    // REQUIRES: cc is not null
    // MODIFIES: this
    // EFFECTS: remove credit card (cc) from cards
    public void removeCreditCard(CreditCard cc) {
        cards.remove(cc);
    }

    // REQUIRES: parameter matches name of a card in list
    // EFFECTS: returns CreditCard object with given name
    public CreditCard takeOutCard(String name) {
        CreditCard result = null;
        for (CreditCard cc : cards) {
            if (Objects.equals(cc.getName(), name)) {
                result = cc;
            }
        }
        return result;
    }

    // REQUIRES: cc is not null, amount > 0
    // MODIFIES: this
    // EFFECTS: pays off credit card with amount deducted from bank balance
    public Boolean payCreditCardBalance(CreditCard cc, int amount) {
        if (bankBalance >= amount && cc.payBill(amount)) {
            cc.payBill(amount);
            bankBalance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public ArrayList<CreditCard> getCards() {
        return cards;
    }

    public int getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }
}
