package ui.tools;

import model.Budget;
import model.CreditCard;
import model.Wallet;

import java.util.ArrayList;
import java.util.Scanner;

//UI Tools for Wallet Class
public class WalletTools {

    private final Scanner scanner;
    private final Wallet wallet;

    public WalletTools(Budget budget) {
        scanner = new Scanner(System.in);
        wallet = new Wallet();
        budget.setWallet(wallet);
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

    public void printCreditCardsUI() {
        int index = 1;
        ArrayList<CreditCard> creditCards = wallet.getCards();
        if (creditCards.size() == 0) {
            System.out.println("No credit cards");
        } else {
            for (CreditCard creditCard : creditCards) {
                System.out.println(
                        index + "."
                                + " Name: " + creditCard.getName()
                                + ", Balance: " + creditCard.getBalance()
                                + ", Limit: " + creditCard.getLimit());
                index++;
            }
        }
    }

    public void printCreditCardUI(CreditCard creditCard) {
        System.out.println("1. Name: " + creditCard.getName());
        System.out.println("2. Balance: " + creditCard.getBalance());
        System.out.println("3. Limit: " + creditCard.getLimit());
    }

    public int selectCreditCardUI() {
        printCreditCardsUI();
        System.out.println("Please select a credit card");
        return scanner.nextInt();
    }

    public void addCreditCardUI() {
        String name;
        int balance;
        int limit;

        System.out.println("Add a new credit card!");

        System.out.println("Name:");
        name = scanner.next();

        System.out.println("Balance:");
        balance = scanner.nextInt();

        System.out.println("Limit:");
        limit = scanner.nextInt();

        wallet.addCreditCard(new CreditCard(name, balance, limit));
        System.out.println("Successfully added a new credit card!");
    }

    public void removeCreditCardUI() {
        int index = selectCreditCardUI();
        wallet.getCards().remove(index - 1);
    }

    public void editCreditCardUI() {
        int index = selectCreditCardUI();
        CreditCard creditCard = wallet.getCards().get(index - 1);
        CreditCard prevCreditCard = new CreditCard(creditCard.getName(), creditCard.getBalance(),
                creditCard.getLimit());
        int nextOperation;
        boolean save = false;
        while (!save) {
            System.out.println();
            System.out.println("Details for Credit Card " + index);
            printCreditCardUI(creditCard);
            System.out.println("What would you like to edit? (1-3)");
            System.out.println("Enter 4 to save changes");
            System.out.println("Enter 5 to exit and cancel changes");
            nextOperation = scanner.nextInt();
            if (nextOperation == 4) {
                break;
            } else if (nextOperation == 5) {
                wallet.getCards().set(index - 1, prevCreditCard);
                break;
            } else {
                editCreditCardLoop(creditCard, nextOperation);
            }
        }
    }

    public void editCreditCardLoop(CreditCard creditCard, int nextOperation) {
        if (nextOperation == 1) {
            System.out.println("Edit Name");
            creditCard.setName(scanner.next());
        } else if (nextOperation == 2) {
            System.out.println("Edit Balance");
            creditCard.setBalance(scanner.nextInt());

        } else if (nextOperation == 3) {
            System.out.println("Edit Limit");
            creditCard.setLimit(scanner.nextInt());
        }
    }

    public void payCreditCardUI() {
        int index = selectCreditCardUI();
        CreditCard cc = wallet.getCards().get(index - 1);
        System.out.println("Current Balance for " + cc.getName() + " is " + cc.getBalance());
        System.out.println("Please enter the amount you would like to pay (in cents)");
        while (true) {
            if (wallet.payCreditCardBalance(cc, scanner.nextInt())) {
                break;
            } else {
                scanner.nextLine();
                System.out.println("Error, please enter a valid amount");
            }
        }
    }


    public ArrayList<CreditCard> getCreditCards() {
        return wallet.getCards();
    }
}
