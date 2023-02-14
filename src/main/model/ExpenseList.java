package model;

import java.util.ArrayList;
import java.util.Scanner;


public class ExpenseList {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Expense> expenseList;
    private int currentExpenses;


    //private String month;

    //EFFECTS: currentExpenses is set to 0,
    //          initializes empty expense list.
    public ExpenseList() {
        expenseList = new ArrayList<>();
        currentExpenses = 0;
    }

    // REQUIRES: expense is not null
    // MODIFIES: this
    // EFFECTS: adds expense to expense list,
    //          increases current expense by expense cost
    public void addExpense(Expense expense) {
        expenseList.add(expense);
        currentExpenses += expense.getCost();
    }

    // REQUIRES: expense is not null
    // MODIFIES: this
    // EFFECTS: removes expense from expense list
    //          decreases current expense by expense cost.
    public void removeExpense(Expense expense) {
        expenseList.remove(expense);
        currentExpenses -= expense.getCost();
    }

    // REQUIRES: expense is not null, index >= 0
    // MODIFIES: this
    // EFFECTS: Replaces expense at the given index with new expense
    //          recalculates current expenses
    public void editExpense(Expense expense, int index) {
        expenseList.set(index, expense);
        currentExpenses = calculateExpenses();
        }

    // EFFECTS: returns the current expense in cents
    public int calculateExpenses() {
        int result = 0;
        for (Expense expense : expenseList) {
            result += expense.getCost();
        }
        return result;
    }

    // REQUIRES: index >= 0
    // EFFECTS: returns the expense object at given index
    public Expense getExpenseAtIndex(int index) {
        return expenseList.get(index);
    }

    // Getters and Setters

    public int getCurrentExpenses() {
        return currentExpenses;
    }

    public void setCurrentExpenses(int currentExpenses) {
        this.currentExpenses = currentExpenses;
    }

    public int getExpenseCount() {
        return expenseList.size();
    }

    public ArrayList<Expense> getExpenseList() {
        return expenseList;
    }

//
//    public ArrayList<Expense> sortByDecreasingPrice() {
//        return expenseList; /*Stub*/
//    }
//
//    public ArrayList<Expense> sortByAscendingPrice() {
//        return expenseList; /*Stub*/
//    }
//
//    public ArrayList<Expense> sortByPurchaseType() {
//        return expenseList; /*Stub*/
//    }
//
//    public ArrayList<Expense> sortByLatestPurchase() {
//        return expenseList; /*Stub*/
//    }
}
