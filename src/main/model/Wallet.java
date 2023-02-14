package model;

import java.util.ArrayList;

public class Wallet {

    private int cash;
    private ArrayList<CreditCard> cards;
    private int bankBalance;

    public Wallet() {
        cash = 0;
        bankBalance =0;
        cards = new ArrayList<>();
    }

    public boolean withdrawCash() {
        return true;
    }
    public boolean depositCash() {
        return true;
    }

    public void addCreditCard() {
        
    }

}
