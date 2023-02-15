package ui.tools;

import model.Wallet;

import java.util.Scanner;

public class WalletTools {

    private Scanner scanner;
    private Wallet wallet;

    public WalletTools() {
        scanner = new Scanner(System.in);
        wallet = new Wallet();
    }
    
    public void setUpWallet() {
        setUpWalletBank();
        setUpWalletCash();
    }

    public void setUpWalletBank() {
        System.out.println("Please enter your current bank balance");
        wallet.setBankBalance(scanner.nextInt());
    }

    private void setUpWalletCash() {
        System.out.println("Please enter the amount of cash you have on hand");
        wallet.setCash(scanner.nextInt());
    }
    
    public int getCashBalance() {
        return wallet.getCash();
    }
    
    public int getBankBalance() {
        return wallet.getBankBalance();
    }

    public void withdrawCashUI() {
    }

    public void depositCashUI() {
    }
}
