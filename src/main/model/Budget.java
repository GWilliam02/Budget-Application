package model;

import java.util.Scanner;

public class Budget {

    private int budget;
    private ExpenseList expenseList;
    private Scanner scanner;


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
        int nextOperation;
        boolean exitDirectory = false;

        while (!exitDirectory) {
            printMainDirMessage();
            nextOperation = scanner.nextInt();

            switch (nextOperation) {
                case 1:
                    setUpBudget();
                    break;
                case 2:
                    expenseDirectory();
                    break;
                case 3:
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
                    expenseList.printExpenses();
                    break;
                case 2:
                    expenseList.addNewExpense();
                    break;
                case 3:
                    expenseList.editExpense();
                    break;
                case 4:
                    expenseList.removeExpense();
                    break;
                case 5:
                    exitDirectory = true;
                    break;
            }
        }
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
        System.out.println("4. Remove expense");
        System.out.println("5. Return to main directory");
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
