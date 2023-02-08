package model;

import java.util.ArrayList;
import java.util.Scanner;

//May change from ArrayList to TreeSet for easier sorting

public class ExpenseList {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Expense> expenseList;
    private int currentExpenses;

    //private String month;


    public ExpenseList() {
        expenseList = new ArrayList<>();
        currentExpenses = 0;
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
        currentExpenses += expense.getCost();
    }

    public void removeExpense(Expense expense) {
        expenseList.remove(expense);
        currentExpenses -= expense.getCost();
    }

    public void editExpense(int index) { //index is > >0
        int nextOperation;
        boolean save = false;
        Expense expense = expenseList.get(index-1);

        while (!save) {
            System.out.println("Details for Expense " + index);
            expense.printExpense();
            System.out.println("What would you like to edit? (1-6)");
            System.out.println("Enter 7 to save changes");
            nextOperation = scanner.nextInt();
            switch (nextOperation) {
                case 1: {
                    System.out.println("Edit cost (Cents)");
                    expense.setCost(scanner.nextInt());
                }
                case 2: {
                    System.out.println("Edit Name");
                    expense.setName(scanner.next());
                }
                case 3: {
                    System.out.println("Edit Comments");
                    expense.setComments(scanner.next());
                }
                case 4: {
                    System.out.println("Edit Purchase Type");
                    expense.setPurchaseType(scanner.next());
                }
                case 5: {
                    System.out.println("Edit Purchase Date");
                    expense.setPurchaseDate(scanner.next());
                }
                case 6: {
                    System.out.println("Recurring?");
                    expense.setRecurring(scanner.nextBoolean());
                }
                case 7: {
                    expenseList.set(index-1,expense);
                    save = true;
                }
            }
        }

        //Get expense that user wants to change
        //Create reference to that expense object
        //Print out current data on the selected Expense
        //Prompt user to edit any fields
        //Confirm changes and print updated Expense
    }

    public double calculateExpenses() {
        double result = 0;
        for (Expense expense: expenseList) {
            result += expense.getCost();
        }
        return result;
    }


    public ArrayList<Expense> sortByDecreasingPrice() {
        return expenseList; /*Stub*/
    }

    public ArrayList<Expense> sortByAscendingPrice() {
        return expenseList; /*Stub*/
    }

    public ArrayList<Expense> sortByPurchaseType() {
        return expenseList; /*Stub*/
    }

    public ArrayList<Expense> sortByLatestPurchase() {
        return expenseList; /*Stub*/
    }



    public int getCurrentExpenses() {
        return currentExpenses;
    }


}
