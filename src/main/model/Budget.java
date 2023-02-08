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
        boolean isAppActive = true;

        while (isAppActive) {
            printDirectoryMessage();
            nextOperation = scanner.nextInt();

            if (nextOperation == 1) {
                setUpBudget();}
            else if (nextOperation == 2) {
                addNewExpense();
            } else if (nextOperation == 3) {
                isAppActive = false;
            }
        }
    }

    private void addNewExpense(){
        int cost;
        String name, comments, purchaseType, purchaseDate;
        boolean recurring;

        System.out.println("Add new expense!");

        System.out.println("Cost:");
        cost = scanner.nextInt();

        System.out.println("Name:");
        name = scanner.next();

        System.out.println("Comments:");
        comments = scanner.next();

        System.out.println("Purchase Type:");
        purchaseType = scanner.next();

        System.out.println("Purchase Date:");
        purchaseDate = scanner.next();

        System.out.println("Recurring? (true or false)");
        recurring = scanner.nextBoolean();

        expenseList.addExpense(new Expense(cost,name,comments,purchaseType,purchaseDate,recurring));
        System.out.println("Successfully added new expense!");
    }

    private void setUpBudget(){
        System.out.println("Please entire your budget for this month (In Cents)");
        budget = scanner.nextInt();
        System.out.println("You have set your budget to: " + budget + " Cents");
    }

    public void printDirectoryMessage() {
        System.out.println("Welcome to the main directory");
        System.out.println("Summary of Budget");
        System.out.println();
        System.out.println("Current Budget: "+ budget);
        //may add feature to automatically specify which month
        System.out.println("Total Expenses for this month: "+ expenseList.getCurrentExpenses());
        System.out.println("Remaining Balance in Budget: "+ (budget- expenseList.getCurrentExpenses()));

        System.out.println();
        System.out.println("Please select the following options below (By entering the corresponding number):");
        System.out.println("1. Change Budget");
        System.out.println("2. Add new expense");
        System.out.println("3. Quit app");
        System.out.println();
    }


    public static void main(String[] args) {
        new Budget();
    }

}
