package model;

import java.util.Scanner;

public class Budget {

    private int budget;
    private ExpenseList expenseList;
    private Scanner scanner;

    private int nextOperation;
    private boolean exitDirectory;

    //Initialization of Budget and empty ExpenseList
    public Budget() {
        scanner = new Scanner(System.in);
        expenseList = new ExpenseList();
        initializeApp();
    }

    private void initializeApp() {
        setUpBudget();
        mainDirectory();
    }

    private void mainDirectory() {
        exitDirectory = false;

        while (!exitDirectory) {
            printMainDirMessage();
            nextOperation = scanner.nextInt();

            switch (nextOperation) {
                case 1:
                    setUpBudget();
                case 2:
                    expenseList.addNewExpense();
                case 3:
                    exitDirectory = true;
            }
        }
    }

    private void expenseDirectory() {
        
    }

    private void printExpenseDirMessage() {
        System.out.println("Welcome to the Expenses directory");
        System.out.println("Summary of Expenses");
        System.out.println();
        System.out.println("Number of expenses: " + expenseList.getExpenseCount());
        System.out.println("Total cost: " + expenseList.getCurrentExpenses());
        System.out.println();
        System.out.println("Please select the following options below (By entering the corresponding number):");
        System.out.println("1. View all expenses");
        System.out.println("2. Add new expense");
        System.out.println("3. Edit existing expense");
        System.out.println("4. Return to main directory");
    }

    private void setUpBudget() {
        System.out.println("Please entire your budget for this month (In Cents)");
        budget = scanner.nextInt();
        System.out.println("You have set your budget to: " + budget + " Cents");
    }

    public void printMainDirMessage() {
        System.out.println("Welcome to the main directory");
        System.out.println("Summary of Budget");
        System.out.println();
        System.out.println("Current Budget: " + budget);
        //may add feature to automatically specify which month
        System.out.println("Total Expenses for this month: " + expenseList.getCurrentExpenses());
        System.out.println("Remaining Balance in Budget: " + (budget - expenseList.getCurrentExpenses()));

        System.out.println();
        System.out.println("Please select the following options below (By entering the corresponding number):");
        System.out.println("1. Change Budget");
        System.out.println("2. Manage Expenses");
        System.out.println("3. Quit app");
        System.out.println();
    }

}
