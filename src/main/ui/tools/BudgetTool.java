package ui.tools;


import model.Budget;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//UI Tools for Budget
public class BudgetTool {

    public static final String JSON_STORE = "./data/testBudget1.json";
    private final Scanner scanner;
    private ExpenseListTools expenseListTools;
    private WalletTools walletTools;
    private Budget budgetApp;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    //Initialization of Budget and empty ExpenseList
    public BudgetTool() throws FileNotFoundException {
        scanner = new Scanner(System.in);
        budgetApp = new Budget();
        expenseListTools = new ExpenseListTools(budgetApp);
        walletTools = new WalletTools(budgetApp);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        initializeApp();
    }

    private void initializeApp() {
        int nextOperation;
        while (true) {
            printSetup();
            nextOperation = scanner.nextInt();
            if (nextOperation == 1) {
                setUpBudget();
                walletTools.setUpWallet();
                break;
            } else if (nextOperation == 2) {
                loadBudget();
                break;
            } else {
                System.out.println("Invalid input, try again");
            }
        }
        mainDirectory();
    }

    private void mainDirectory() {
        int nextOperation;
        boolean exitDirectory = false;

        while (!exitDirectory) {
            printMainDirMessage();
            nextOperation = scanner.nextInt();

            if (nextOperation == 6) {
                exitDirectory = true;
            } else {
                mainDirectoryAction(nextOperation);
            }
        }
    }

    private void mainDirectoryAction(int nextOperation) {
        switch (nextOperation) {
            case 1:
                setUpBudget();
                break;
            case 2:
                expenseDirectory();
                break;
            case 3:
                walletDirectory();
                break;
            case 4:
                loadBudget();
                break;
            case 5:
                saveBudget();
                break;
        }
    }

    private void walletDirectory() {
        int nextOperation;
        boolean exitDirectory = false;

        while (!exitDirectory) {
            printWalletDirMessage();
            nextOperation = scanner.nextInt();

            switch (nextOperation) {
                case 1:
                    walletTools.setUpWalletBank();
                    break;
                case 2:
                    walletTools.withdrawCashUI();
                    break;
                case 3:
                    walletTools.depositCashUI();
                    break;
                case 4:
                    creditCardDirectory();
                    break;
                case 5:
                    exitDirectory = true;
                    break;
            }

        }
    }

    private void creditCardDirectory() {
        int nextOperation;
        boolean exitDirectory = false;

        while (!exitDirectory) {
            printCreditCardDirMessage();
            nextOperation = scanner.nextInt();

            switch (nextOperation) {
                case 1:
                    walletTools.addCreditCardUI();
                    break;
                case 2:
                    walletTools.removeCreditCardUI();
                    break;
                case 3:
                    walletTools.editCreditCardUI();
                    break;
                case 4:
                    walletTools.payCreditCardUI();
                    break;
                case 5:
                    exitDirectory = true;
                    break;
            }
        }
    }

    private void expenseDirectory() {
        int nextOperation;
        boolean exitDirectory = false;

        while (!exitDirectory) {
            printExpenseDirMessage();
            nextOperation = scanner.nextInt();

            switch (nextOperation) {
                case 1:
                    expenseListTools.printExpensesUI();
                    break;
                case 2:
                    expenseListTools.addNewExpenseUI();
                    break;
                case 3:
                    expenseListTools.editExpenseUI();
                    break;
                case 4:
                    expenseListTools.removeExpenseUI();
                    break;
                case 5:
                    exitDirectory = true;
                    break;
            }
        }
    }

    private void printSetup() {
        System.out.println("Welcome to the budgeting app!");
        System.out.println("Please select the following options below");
        System.out.println("1. Create a new Budget plan");
        System.out.println("2. Load existing Budget plan");
    }

    private void setUpBudget() {
        System.out.println("Please enter your budget for this month (In Cents)");
        budgetApp.setMonthlyBudget(scanner.nextInt());
        System.out.println("You have set your budget to: " + budgetApp.getMonthlyBudget() + " Cents");
    }

    private void printCreditCardDirMessage() {
        System.out.println("Welcome to the Credit Cards directory");
        System.out.println("Summary of Credit Cards");
        walletTools.printCreditCardsUI();
        System.out.println();
        System.out.println("Please select the following options below (By entering the corresponding number):");
        System.out.println("1. Add Credit Card");
        System.out.println("2. Delete Credit Card");
        System.out.println("3. Edit Credit Card");
        System.out.println("4. Pay Off Credit Card Balance");
        System.out.println("5. Return to Wallet Directory");

    }

    private void printWalletDirMessage() {
        System.out.println("Welcome to the Wallet directory");
        System.out.println("Summary of Wallet");
        System.out.println();
        System.out.println("Cash: " + walletTools.getCashBalance());
        System.out.println("Bank Balance " + walletTools.getBankBalance());
        System.out.println("Credit Cards: " + walletTools.getCreditCards().size());
        System.out.println();
        System.out.println("Please select the following options below (By entering the corresponding number):");
        System.out.println("1. Change Bank Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Manage Credit Card");
        System.out.println("5. Return to main directory");
    }

    private void printExpenseDirMessage() {
        System.out.println("Welcome to the Expenses directory");
        System.out.println("Summary of Expenses");
        System.out.println();
        System.out.println("Number of expenses: " + expenseListTools.getNumberOfExpenses());
        System.out.println("Total cost: " + expenseListTools.getCurrentExpenses());
        System.out.println();
        System.out.println("Please select the following options below (By entering the corresponding number):");
        System.out.println("1. View all expenses");
        System.out.println("2. Add new expense");
        System.out.println("3. Edit existing expense");
        System.out.println("4. Remove expense");
        System.out.println("5. Return to main directory");
    }

    public void printMainDirMessage() {
        System.out.println("Welcome to the main directory");
        System.out.println("Summary of Budget");
        System.out.println();
        System.out.println("Current Budget: " + budgetApp.getMonthlyBudget());
        //may add feature to automatically specify which month
        System.out.println("Total Expenses for this month: " + expenseListTools.getCurrentExpenses());
        System.out.println("Remaining Balance in Budget: "
                + (budgetApp.getMonthlyBudget() - expenseListTools.getCurrentExpenses()));

        System.out.println();
        System.out.println("Please select the following options below (By entering the corresponding number):");
        System.out.println("1. Change Budget");
        System.out.println("2. Manage Expenses");
        System.out.println("3. Open Wallet");
        System.out.println("4. Load budget");
        System.out.println("5. Save budget");
        System.out.println("6. Quit app");
        System.out.println();
    }

    //MODIFIES: this
    //EFFECTS: loads Budget from file
    public void loadBudget() {
        try {
            budgetApp = jsonReader.readBudget();
            expenseListTools = new ExpenseListTools(budgetApp);
            walletTools = new WalletTools(budgetApp);
            System.out.println("Loaded BudgetApp from: " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read data from file: " + JSON_STORE);
        }
    }

    //EFFECTS: save the current Budget to file
    private void saveBudget() {
        try {
            jsonWriter.open();
            jsonWriter.write(budgetApp);
            jsonWriter.close();
            System.out.println("Saved Budget Progress to" + JSON_STORE);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to save to file: " + JSON_STORE);
        }
    }

}
