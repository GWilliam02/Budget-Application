package ui.tools;

import model.Wallet;

import java.util.Scanner;

public class WalletTools {

    private final Scanner scanner;
    private final Wallet wallet;

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
        int withdrawAmount;
        while (true) {
            System.out.println("Your bank balance is " + wallet.getBankBalance());
            System.out.println("Please enter the amount of cash you would like to withdraw");
            withdrawAmount = scanner.nextInt();
            if (wallet.withdrawCash(withdrawAmount)) {
                break;
            } else {
                System.out.println("Insufficient Balance!");
            }
        }
    }

    public void depositCashUI() {
        int depositAmount;
        while (true) {
            System.out.println("Cash available for deposit " + wallet.getCash());
            System.out.println("Please enter the amount of cash you would like to deposit");
            depositAmount = scanner.nextInt();
            if (wallet.depositCash(depositAmount)) {
                break;
            } else {
                System.out.println("Insufficient Cash for deposit");
            }
        }
    }
}
